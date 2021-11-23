<template>
<div class="form">
    <div id="box">
        <div id="headtext">УИК №{{number}}</div>

        <form class="formed_box">
            <div class="user-box">
                <label>Собянин Сергей Семёнович</label>
                <input  type="number" pattern="[0-9]+" v-model="c1_votes" placeholder="0" required/>
            </div>
            <div class="user-box">
                <label>Кумин Вадим Валентинович</label>
                <input type="number" pattern="[0-9]+" v-model="c2_votes" placeholder="0" required />
            </div>
            <div class="user-box">
                <label>Свиридов Илья Тимурович</label>
                <input type="number" pattern="[0-9]+" v-model="c3_votes" placeholder="0" required/>
            </div>
            <div class="user-box">
                <label>Дегтярёв Михаил Васильевич</label>
                <input type="number" pattern="[0-9]+" v-model="c4_votes" placeholder="0" required/>
            </div>
            <div class="user-box">
                <label>Балакин Михаил Дмитриевич</label>
                <input type="number" pattern="[0-9]+" v-model="c5_votes" placeholder="0" required/>
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
          localStorage.setItem("c1_votes", this.c1_votes);
          localStorage.setItem("c2_votes", this.c2_votes);
          localStorage.setItem("c3_votes", this.c3_votes);
          localStorage.setItem("c4_votes", this.c4_votes);
          localStorage.setItem("c5_votes", this.c5_votes);

        //   const payload = { // сюда кладем то, что хотим заслать на бекенд
        //       "c1_votes": this.c1_votes,
        //       "c2_votes": this.c2_votes,
        //       "c3_votes": this.c3_votes,
        //       "c4_votes": this.c4_votes,
        //       "c5_votes": this.c5_votes,
        //   };

        //   fetch("http://vash-backend.org/api/saveVoters", {
        //       method: "POST",
        //       body: JSON.stringify(payload)
        //   }).then(r => { /* а тут что-то можем сделать с ответом */ })
      }
  },
  data: () => {
       const savedNumber = localStorage.getItem("number");

       const c1_votes = localStorage.getItem("c1_votes");
       const c2_votes = localStorage.getItem("c2_votes");
       const c3_votes = localStorage.getItem("c3_votes");
       const c4_votes = localStorage.getItem("c4_votes");
       const c5_votes = localStorage.getItem("c5_votes");

    return  {
    number: savedNumber ?? 1,
    c1_votes: c1_votes ?? 0,
    c2_votes: c2_votes ?? 0,
    c3_votes: c3_votes ?? 0,
    c4_votes: c4_votes ?? 0,
    c5_votes: c5_votes ?? 0
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
    margin: 20px 25%;
    padding: 20px 80px;

    min-width: 800px;
    width:20%;
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
    font-size: 28px;
    letter-spacing: 0.12em;
    color: #000000;
}

.user-box{
    position: relative;
    display: flex;
    justify-content: center;
    flex: 1 0 auto;
    padding: 5px;
    grid-column: span 2;
}

.user-box label{
    flex: 0 1 300px;
    margin-top: 10px;
    font-family: Roboto;
    padding-left: 20px;
    font-size: 20px;
    color: #342F3C;
}

.user-box input{
    outline: none;
    width: 50px;
    height: 10px;
    margin: 0 10px;
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
    margin-bottom: 10px;
    top: 5px;

    width: 200px;
    height: 45px;

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
</style>