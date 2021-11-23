<template>
<div id="app">   
    <div id="logo">
      <img src="@/logo.png"/>
    </div>  
      <router-view/>
  </div>
</template>

<script>
import home from '@/views/home.vue'
import form from '@/views/form.vue'
import diagrams from '@/views/diagrams.vue'
import results from "@/views/results.vue"
import form_results from "@/views/form_results.vue"

export default {
  name: 'App',
  props: {
    home,
    form,
    diagrams,
    results,
    form_results
  }
}
</script>

<style>
html {
    min-height: 100%;
}
body {
    margin: 0;
    background: linear-gradient(0deg, hsl(240, 65%, 73%), #ffffff);
    min-height: 100%;
}

#logo{
    position: relative;
    text-align: center;
    margin: 25px auto;
    width:60%;
    text-transform: uppercase;
    
    font-family: Impact;
    font-size: 24px;
    letter-spacing: 0.18em;
    color: #354F67;
}
</style>