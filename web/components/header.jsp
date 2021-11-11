<body>
    
    <div style="width:100%; background-color: #2186bd;" class="p-2 d-flex align-items-center">
        <h5 class="text-white flex-grow-1">CCOS-BCA Personal Loan</h5>
        <span class="text-white">Welcome, <%= session.getAttribute("name") %>!</span>
        <i class="mdi mdi-clock-outline ml-3 text-white"></i>
        <span class="text-white ml-1" id="clock"></span>
    </div>
</body>

<script>
    function updateClock() {
        var date= new Date();
        var hr = date.getHours();
        var m = date.getMinutes();
        var s = date.getSeconds();
        if(m < 10)
        {
            m = "0" + m
        }
        if(s < 10)
        {
            s = "0" + s
        }
        document.getElementById("clock").textContent = hr + ":" + m + ":" + s;
    }


    $(document).ready(function () {

        // Clock
        updateClock();
        setInterval(updateClock, 1000);
    });
</script>