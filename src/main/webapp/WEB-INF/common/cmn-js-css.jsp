<script>
var CONTEXT = "${pageContext.request.contextPath}";
</script>

	<link href="${pageContext.request.contextPath}/resources/dist/css/base/vendors.bundle.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/dist/css/base/style.bundle.main.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/dist/css/base/style.bundle.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/dist/css/base/slider-pro.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/dist/css/base/examples.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/dist/css/custom/custom.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/base/animate.css">
    
    

    
    
        <script src="${pageContext.request.contextPath}/resources/dist/js/base/vendors.bundle.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/dist/js/base/scripts.bundle.main.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/dist/js/base/scripts.bundle.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/dist/js/base/parallax.min.js" type="text/javascript"></script>
        
        <script>
          $(window).on('load', function() {
            $('body').removeClass('m-page--loading');
          });
          $('.bg-parallax').parallax({
            imageSrc: '${pageContext.request.contextPath}/resources/dist/images/bgchoose.jpg',
            naturalHeight: 400
          });
          $(function() {
            if (navigator.userAgent.match(/(iPod|iPhone|iPad|Android)/)) {
              $('#ios-notice').removeClass('hidden');
              $('.bg-parallaxr').height($(window).height() * 0.5 | 0);
            } else {
              $(window).resize(function() {
                var parallaxHeight = Math.max($(window).height() * 0.7, 200) | 0;
                $('.bg-parallax').height(parallaxHeight);
              }).trigger('resize');
            }
          });
        </script>

<style>

</style>

<script>

</script>
         
          