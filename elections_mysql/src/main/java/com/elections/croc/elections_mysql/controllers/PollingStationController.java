package com.elections.croc.elections_mysql.controllers;

import com.elections.croc.elections_mysql.model.PollingStation;
import com.elections.croc.elections_mysql.model.Tik;
import com.elections.croc.elections_mysql.model.VotesForCandidates;
import com.elections.croc.elections_mysql.service.PollingStationService;
import com.elections.croc.elections_mysql.service.TikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PollingStationController {

    private final PollingStationService pollingStationService;
    private final TikService tikService;

    @Autowired
    public PollingStationController(PollingStationService pollingStationService, TikService tikService) {
        this.pollingStationService = pollingStationService;
        this.tikService = tikService;
    }

    @GetMapping("/update-information-station/{id}")
    public String updatePollingStationForm(@PathVariable("id") int id, Model model){
        PollingStation pollingStation = new PollingStation();
        pollingStation.setIdStation(id);
        pollingStation.setNameStation(pollingStationService.findById(id).getNameStation());
        model.addAttribute("pollingStation", pollingStation);
        return "pollingStation/pollingStationUpdate";
    }

    @PostMapping("/update-information-station")
    public String updatePollingStation(@ModelAttribute("pollingStation") @Valid PollingStation pollingStation,
                                       BindingResult bindingResult, Model model){
        int id = pollingStation.getIdStation();
        if (bindingResult.hasErrors()){
            return "pollingStation/pollingStationUpdate";
        }

        PollingStation pollingStationInBase = pollingStationService.findById(pollingStation.getIdStation());
        double percent = Math.round((pollingStation.getAmountVotersShowed() + pollingStationInBase.getAmountVotersShowed()) * 1.0
                / pollingStationInBase.getAmountVoters() * 10000) / 100.0;

        pollingStationInBase.setAmountVotersShowed(pollingStationInBase.getAmountVotersShowed()
                                                    + pollingStation.getAmountVotersShowed());
        pollingStationInBase.setAmountIssuedBulletins(pollingStationInBase.getAmountIssuedBulletins()
                                                     + pollingStation.getAmountIssuedBulletins());
        pollingStationInBase.setAmountSpoiledBulletins(pollingStationInBase.getAmountSpoiledBulletins()
                                                    + pollingStation.getAmountSpoiledBulletins());
        pollingStationInBase.setAmountDroppedBulletins(pollingStationInBase.getAmountDroppedBulletins()
                                                    + pollingStation.getAmountDroppedBulletins());
        pollingStationInBase.setPercentVoters(percent);
        pollingStationService.savePollingStation(pollingStationInBase);
        Tik tik = tikService.findById(pollingStationInBase.getIdTik());
        tik.setAmountVotersShowed(tik.getAmountVotersShowed() + pollingStation.getAmountVotersShowed());
        double percentTik = Math.round(tik.getAmountVotersShowed() * 1.0
                / tik.getAmountVoters() * 10000) / 100.0;
        tik.setPercentVoters(percentTik);
        tikService.saveTik(tik);


        return "redirect:/update-information-station/" + id;
    }

    @GetMapping("/update-information-station")
    public String showPollingStations(){
        return "pollingStation/pollingStations.html";
    }

    @GetMapping("/tiks")
    public String showInfoOnTiks(Model model){

        for (int i = 1; i <= 5; i++){
            String name = "tik" + i;
            model.addAttribute(name, tikService.findById(i));
        }
        return "tiks/tiks-info";
    }

//    @GetMapping("all_attendance")
//    public String allAttendance(Model model){
//        int showedVoters = 0;
//        int allVoters = 0;
//        List<Tik> tikList = tikService.findAll();
//        for (Tik tik : tikList){
//            showedVoters += tik.getAmountVotersShowed();
//            allVoters += tik.getAmountVoters();
//        }
//
//        double percent = Math.round(showedVoters*1.0/ allVoters * 10000) / 100.0;
//        model.addAttribute("showedVoters", showedVoters);
//        model.addAttribute("allVoters", allVoters);
//
//        model.addAttribute("percent", percent);
//
//        return "attedance/all-attedance";
//    }
}
