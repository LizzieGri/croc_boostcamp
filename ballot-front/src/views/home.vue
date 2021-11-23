<template>
    <div class="home">
    <div id="box">
        <form class="formed_box">
            <div id="headtext">Добро пожаловать!</div>
            <button @click="$router.push('/form')">
                <a>Заполнить форму по явке</a>
            </button>
            <button @click="$router.push('/form-results')">
                <a>Заполнить форму по итогам</a>
            </button>
        </form>
    </div>
  </div>
</template>

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
}

#headtext{
    position: relative;
    text-align: center;
    margin: auto;
    margin-bottom:30px;

    font-family: Open Sans;
    font-size: 32px;
    letter-spacing: 0.12em;
    color: #000000;
}

button, .button{
    cursor: pointer;
    position: relative;
    display: flex;
    justify-content: center;
    margin: auto;
    margin-bottom: 60px;
    top: 20px;

    width: 400px;
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
    font-size: 25px;
    color: #E3E3E3;
    text-decoration: none;
    letter-spacing: 0.05em;
}
</style>