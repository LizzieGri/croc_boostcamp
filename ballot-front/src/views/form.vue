<template>
<div class="form">
    <div id="box">
        <div id="headtext">УИК №{{number}}</div>

        <form class="formed_box">
            <div class="user-box">
                <label>Количество явившихся избирателей</label>
                <input  type="number" pattern="[0-9]+" v-model="number_of_voters" placeholder="0" required/>
            </div>
            <div class="user-box">
                <label>Общее число выданных бюллетеней</label>
                <input type="number" pattern="[0-9]+" v-model="total_number_of_ballots" placeholder="0" required />
            </div>
            <div class="user-box">
                <label>Количество испорченных бюллетеней</label>
                <input type="number" pattern="[0-9]+" v-model="number_of_spoilet_ballots" placeholder="0" required/>
            </div>
            <div class="user-box">
                <label> Количество опущенных в урну бюллетеней</label>
                <input type="number" pattern="[0-9]+" v-model="number_of_omitted_ballots" placeholder="0" required/>
            </div>
            <div class="submit-button-row">
                <button @click="checkForm">
                    <a>Сохранить</a>
                </button>
            </div>
        </form>
        <button @click="$router.push('/')">
                <a style="font-size: 15px;">Вернуться на домашнюю страницу</a>
        </button>
    </div>
  </div>
</template>

<script>
 export default{
  name: 'form',
  methods: {
      checkForm: function () {
          localStorage.setItem("number_of_voters", this.number_of_voters);
          localStorage.setItem("total_number_of_ballots", this.total_number_of_ballots);
          localStorage.setItem("number_of_spoilet_ballots", this.number_of_spoilet_ballots);
          localStorage.setItem("number_of_omitted_ballots", this.number_of_omitted_ballots);

        //   const payload = { // сюда кладем то, что хотим заслать на бекенд
        //       "number_of_voters": this.number_of_voters,
        //       "total_number_of_ballots": this.total_number_of_ballots,
        //       "number_of_spoilet_ballots": this.number_of_spoilet_ballots,
        //       "number_of_omitted_ballots": this.number_of_omitted_ballots,
        //   };

        //   fetch("http://vash-backend.org/api/saveVoters", {
        //       method: "POST",
        //       body: JSON.stringify(payload)
        //   }).then(r => { /* а тут что-то можем сделать с ответом */ })
      }
  },
  data: () => {
       const savedNumber = localStorage.getItem("number");

       const number_of_voters = localStorage.getItem("number_of_voters");
       const total_number_of_ballots = localStorage.getItem("total_number_of_ballots");
       const number_of_spoilet_ballots = localStorage.getItem("number_of_spoilet_ballots");
       const number_of_omitted_ballots = localStorage.getItem("number_of_omitted_ballots");

    return  {
    number: savedNumber ?? 1,
    number_of_voters: number_of_voters ?? 0,
    total_number_of_ballots: total_number_of_ballots ?? 0,
    number_of_spoilet_ballots: number_of_spoilet_ballots ?? 0,
    number_of_omitted_ballots: number_of_omitted_ballots ?? 0
    }
  }
}
</script>

<style scoped>
#logo{
    position: relative;
    text-align: center;
    margin: 40px auto;
    width:60%;
    text-transform: uppercase;
    
    font-family: Impact;
    font-size: 24px;
    letter-spacing: 0.18em;
    color: #354F67;
}

.formed_box{
    position: relative;
    margin: 20px 10%;
    padding: 20px 80px;

    min-width: 1000px;
    width:80%;
    min-height: 50px;
    background: rgba(255, 255, 255, 0.564);
    border-radius: 30px;
    box-sizing: border-box;

    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-gap: 20px;
}

.submit-button-row {
    grid-column: span 2;
}

#headtext{
    position: relative;
    text-align: center;
    margin: auto;

    font-family: Open Sans;
    font-size: 32px;
    letter-spacing: 0.12em;
    color: #000000;
}

.users_row{
  position: flex;
    display: table-row;  
    margin: auto;
}

.user-box{
    position: relative;
    display: table-cell;   
    flex: 1 0 auto;
    padding: 5px;
}

.user-box label{
    flex: 0 1 300px;

    font-family: Roboto;
    padding-left: 20px;
    font-size: 20px;
    color: #342F3C;
}

.user-box input{
    outline: none;
    width: 70px;
    height: 40px;
    margin: 10px;
    padding: 12px;

    font-family: Roboto Mono;
    font-style: italic;
    font-size: 24px;
    color: #000000;
    background: hsl(240, 65%, 73%);
    border-radius: 30px;
}

button, .button{
    cursor: pointer;
    position: relative;
    display: flex;
    justify-content: center;
    margin: auto;
    margin-bottom: 30px;
    top: 20px;

    width: 200px;
    height: 55px;

    box-shadow: inset 0 -25px rgba(0, 0, 0, 17%);
    background: #303752;
    border-radius: 3px;
}

button a, .button a{
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    vertical-align: middle;
    font-family: Roboto Mono;
    font-style: normal;
    font-size: 30px;
    color: #E3E3E3;
    text-decoration: none;
    letter-spacing: 0.05em;
}

span {

}
</style>