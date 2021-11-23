<template>
    <div class="dia">
        <h2>ТИК №{{item.id}}</h2>
          <canvas ref="pieDiagram" style="max-height: 150px"/>
        <h4>Всего жителей: {{ item.total_all}} </h4>
    </div>
</template>

<script>
import { Chart, registerables } from "chart.js";

export default {
  name: 'Diagram',
  props: {
    item: {
      type: Object,
      default: null
    },
  },
  mounted() {
    let ctx = this.$refs.pieDiagram.getContext("2d");

    const totalVotedDataset = this.item.total_voted;
    const totalNotVotedDataset = this.item.total_all -  this.item.total_voted;
    const colors = ['#5c5466', '#E46651']; 
    const data = {
      datasets: [
        {
          data: [totalVotedDataset, totalNotVotedDataset],
          backgroundColor: colors,
        }
      ],
    };

    new Chart(ctx, {
      type: "pie",
      data
    });
  },
  created() {
    Chart.register(...registerables);
  },
  
}
</script>

<style scope>
.dia {
  position: relative;
  display: inline-block;   
  flex: 1 0 auto; 
  border-radius: 10px; 
  box-sizing: border-box;
  padding: 0 10px;
  margin: 20px;
  
  width: 300px;
  background-color: rgba(12, 11, 17, 0.435);
}

.dia h2{
  text-align: center;
  margin: 8px auto;
  font-size: 18px;
  text-transform: uppercase;
}

.dia h4{
  text-align: right;
  font-family: Roboto Mono;
  font-style: italic;
  color: #1e162f;
}

.pie{
  display: block; 
  margin: 0 auto;
  box-sizing: border-box;
  max-height: 150px;
  max-width: 150px;
}
</style>