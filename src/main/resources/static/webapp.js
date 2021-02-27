var webapp = (function () {
    function changeImage() {
        if(document.getElementById("ibai").style.display === "none"){
            document.getElementById("ibaibutton").value = "Ibai says goodbye";
            document.getElementById("ibai").style = "display : block; margin: 0 auto";
        }
        else {
            document.getElementById("ibaibutton").value = "Ibai says hello";
            document.getElementById("ibai").style = "display : none; margin: 0 auto";
        }
    }
    return {
        changeImage:changeImage
    };
})();