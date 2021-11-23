<template>
<div class="diagrams">
  <div id="headtext"><h1>Итоги явки</h1></div>
  <div class="formed_box">

  <div class="items" v-for="tps_item in tpss.tps" :key="tps_item.id">
    <diagram  :item="tps_item" />
  </div>
  
  <div class="btm">
      <div class="lbl">Последнее обновление</div>
      <div class="time">{{ tpss.time }}</div>
    </div>
  </div>

  <button @click="$router.push('/')">
    <a style="font-size: 15px;">Вернуться на домашнюю страницу</a>
  </button>
  </div>
</template>

<script>
import Diagram from '@/components/diagram.vue'
import tpss from '@/json/tpsList.json'

export default {
  name: 'diagrams',
  components: {
    Diagram
  },
  data(){
    return{
       tpss
      }
  }
  }
</script>

<style scoped>
#headtext{
    position: relative;
    text-align: center;
    margin: auto;

    font-family: Open Sans;
    font-size: 10px;
    letter-spacing: 0.12em;
    color: #1e162f;
    
    text-transform: uppercase;
}

.formed_box{
    position: relative;
    margin: 0 10%;
    padding: 20px 40px ;

    width:80%;
    height: 700px;
    background: rgba(255, 255, 255, 0.564);
    border-radius: 10px;
    box-sizing: border-box;
}

.items {
  display: inline-block;
  margin: 0 auto;
}

.btm {
  position: relative;
  display: table;
  justify-content: center;
  margin: auto;
}

.lbl {
  display: flex;
  margin: 10px auto;
  justify-content: center;
  font-family: Open Sans;
  letter-spacing: 0.12em;
  color: #1e162f;
}

.time {
    position: absolute;
    display: table-cell;
    outline: none;
    width: 300px;
    height: 30px;
    padding: 10px;
    left: -50px;

    font-family: Roboto Mono;
    font-style: italic;
    font-size: 24px;
    color: #1e162f;
    background: rgba(14, 11, 17, 0.435);
    border-radius: 10px;
}

button, .button{
    cursor: pointer;
    position: relative;
    display: flex;
    justify-content: center;
    margin: 20px auto;

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