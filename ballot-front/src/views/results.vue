<template>
    <div class="results">
        <div id="headtext">Выборы мэра Москвы</div>

        <vue3-chart-js class="pie"
            :type="pieChart.type"
            :data="pieChart.data"
        />

        <div class="line_can">
        <div class="candidates">
            <div id="clr" style="background-color: #352C5B"></div>
            <img src="@/pics/c1.jpg">
            <p><span>Сергей<br>Семёнович<br>Собянин</span></p>
        </div>
        <div class="candidates">
            <div id="clr" style="background-color: #4F3B6F"></div>
            <img src="@/pics/c2.jpeg">
            <p><span>Вадим<br>Валентинович<br>Кумин</span></p>
        </div>
        <div class="candidates">
            <div id="clr" style="background-color: #824867"></div>
            <img src="@/pics/c3.jpeg">
            <p><span>Илья<br>Тимурович<br>Свиридов</span></p>
        </div>
        <div class="candidates">
            <div id="clr" style="background-color: #975858"></div>
            <img src="@/pics/c4.jpg">
            <p><span>Михаил<br>Владимирович<br>Дегтярёв</span></p>
        </div>
        <div class="candidates">
            <div id="clr" style="background-color: #BD6B60"></div>
            <img src="@/pics/c5.webp">
            <p><span>Михаил<br>Дмитриевич<br>Балакин</span></p>
        </div>
        </div>
    </div>
</template>

<script>
import Vue3ChartJs from '@j-t-mcc/vue3-chartjs'
import res from "@/json/res.json"

export default {
    name: 'results',
    components: {
        Vue3ChartJs
    },
    data(){
        return{
            res
        }
    },
    setup() {
        const totalResults = res.res;
        const dataColors = [
                 '#352C5B',
                '#4F3B6F',
                '#824867', 
                '#975858',
                '#BD6B60'
        ];

        var pieChart = {
        id: 'pie',
        type: 'pie',
        data: {
            datasets: [
            {   backgroundColor: dataColors,
                data: totalResults,
            }
            ]
        }
        }

    return {
      pieChart
    }
  }
}
</script>

<style scoped>
.results {
    background-image: url('~@/pics/FON.jpg');
    height: 200%;
}

#headtext{
    position: relative;
    text-align: center;
    margin: 20px auto;

    text-transform: uppercase;

    font-family: Open Sans;
    font-size: 32px;
    letter-spacing: 0.12em;
    color: #ba1a1a;
}

.pie{
  display: block; 
  margin: 0 auto;
  box-sizing: border-box;
  max-height: 300px;
  max-width: 300px;
} 

.line_can {
    margin: 0 auto;
}

.candidates {
    display: inline-block; 
    margin: 30px 65px;
}

#clr {
    height: 12px;
    margin: 20px 0;
}

img {
    height: 220px;
}

.candidates span {
    font-size: 25px;
    font-family: Open Sans;
    color: #ba1a1a;
}
</style>