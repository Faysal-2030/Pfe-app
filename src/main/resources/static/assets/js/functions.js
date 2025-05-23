!function(e){"use strict";e(window).on("load",function(){e("#status").fadeOut(),e("#preloader").delay(350).fadeOut("slow"),e("body").delay(350).css({overflow:"visible"}),e(window).scroll()}),e(window).on("scroll",function(){e(this).scrollTop()>1?e("header").addClass("sticky"):e("header").removeClass("sticky")}),e("a.open_close").on("click",function(){e(".main-menu").toggleClass("show"),e(".layer").toggleClass("layer-is-visible")}),e("a.show-submenu").on("click",function(){e(this).next().toggleClass("show_normal")}),e("a.show-submenu-mega").on("click",function(){e(this).next().toggleClass("show_mega")}),e(function(){e(window).width()<=480&&e("a.open_close").on("click",function(){e(".cmn-toggle-switch").removeClass("active")})}),e(function(){e(this).width()<991?e(".collapse#collapseFilters").removeClass("show"):e(".collapse#collapseFilters").addClass("show")}),e(".expose").on("click",function(o){e(this).css("z-index","4"),e("#overlay").fadeIn(300)}),e("#overlay").on("click",function(o){e("#overlay").fadeOut(300,function(){e(".expose").css("z-index","3")})});[].slice.call(document.querySelectorAll('[class="tooltip-1"]')).map(function(e){return new bootstrap.Tooltip(e)});e(".accordion_styled").on("hidden.bs.collapse shown.bs.collapse",function(o){e(o.target).prev(".card-header").find("i.indicator").toggleClass("icon-minus icon-plus")}),e(".btn_map").on("click",function(){var o=e(this);o.text()==o.data("text-swap")?o.text(o.data("text-original")):o.text(o.data("text-swap"))}),(new WOW).init(),e(function(){e(".parallax-window").parallax({zIndex:1}),e(".video").magnificPopup({type:"iframe",closeMarkup:'<button title="%title%" type="button" class="mfp-close" style="font-size:21px">&#215;</button>'}),e(".magnific-gallery").each(function(){e(this).magnificPopup({delegate:"a",type:"image",preloader:!0,gallery:{enabled:!0},removalDelay:500,callbacks:{beforeOpen:function(){this.st.image.markup=this.st.image.markup.replace("mfp-figure","mfp-figure mfp-with-anim"),this.st.mainClass=this.st.el.attr("data-effect")}},closeOnContentClick:!0,midClick:!0})}),e(".dropdown-menu").on("click",function(e){e.stopPropagation()}),e("ul#top_tools li .dropdown").hover(function(){e(this).find(".dropdown-menu").stop(!0,!0).delay(50).fadeIn(300)},function(){e(this).find(".dropdown-menu").stop(!0,!0).delay(50).fadeOut(300)});for(var o=document.querySelectorAll(".cmn-toggle-switch"),a=o.length-1;a>=0;a--){t(o[a])}function t(e){e.addEventListener("click",function(e){e.preventDefault(),!0===this.classList.contains("active")?this.classList.remove("active"):this.classList.add("active")})}e(window).on("scroll",function(){e(window).scrollTop()>=800?e("#toTop").addClass("visible"):e("#toTop").removeClass("visible")}),e("#toTop").on("click",function(){return e("html, body").animate({scrollTop:0},500),!1}),e(".numbers-row").append('<div class="inc button_inc">+</div><div class="dec button_inc">-</div>'),e(".button_inc").on("click",function(){var o=e(this),a=o.parent().find("input").val();if("+"==o.text())var t=parseFloat(a)+1;else if(a>1)t=parseFloat(a)-1;else t=0;o.parent().find("input").val(t)})}),e("ul#cat_nav li a").on("click",function(){e("ul#cat_nav li a.active").removeClass("active"),e(this).addClass("active")}),e("#map_filter ul li a").on("click",function(){e("#map_filter ul li a.active").removeClass("active"),e(this).addClass("active")}),e(function(){e("#range").ionRangeSlider({hide_min_max:!0,keyboard:!0,min:0,max:150,from:30,to:100,type:"double",step:1,prefix:"$",grid:!0})}),e(window).width()>=768&&e("footer.revealed").footerReveal({shadow:!1,opacity:.6,zIndex:0}),e(".search-overlay-menu-btn").on("click",function(o){e("body").addClass("has-fullscreen-modal"),e(".search-overlay-menu").addClass("open"),e('.search-overlay-menu > form > input[type="search"]').focus()}),e(".search-overlay-close").on("click",function(o){e(".search-overlay-menu").removeClass("open"),e("body").removeClass("has-fullscreen-modal")}),e(".search-overlay-menu, .search-overlay-menu .search-overlay-close").on("click keyup",function(o){(o.target==this||"search-overlay-close"==o.target.className||27==o.keyCode)&&e(this).removeClass("open")}),e("#access_link").magnificPopup({type:"inline",fixedContentPos:!0,fixedBgPos:!0,overflowY:"auto",closeBtnInside:!0,preloader:!1,midClick:!0,removalDelay:300,mainClass:"my-mfp-zoom-in"}),e("#password").hidePassword("focus",{toggle:{className:"my-toggle"}}),e("#forgot").on("click",function(){e("#forgot_pw").fadeToggle("fast")}),e(".opacity-mask").each(function(){e(this).css("background-color",e(this).attr("data-opacity-mask"))}),e("#carousel-home .owl-carousel").on("initialized.owl.carousel",function(){setTimeout(function(){e("#carousel-home .owl-carousel .owl-item.active .owl-slide-animated").addClass("is-transitioned"),e("section").show()},200)});const o=e("#carousel-home .owl-carousel").owlCarousel({items:1,loop:!0,nav:!1,dots:!0,responsive:{0:{dots:!1},767:{dots:!1},768:{dots:!0}}});function a(){e(".panel-dropdown").removeClass("active")}o.on("changed.owl.carousel",function(o){e(".owl-slide-animated").removeClass("is-transitioned"),e(".owl-item").eq(o.item.index).find(".owl-slide-animated").addClass("is-transitioned")}),o.on("resize.owl.carousel",function(){setTimeout(function(){},50)}),e(".list_carousel").owlCarousel({center:!1,items:2,loop:!1,margin:0,dots:!1,nav:!0,navText:["<i class='arrow_carrot-left'></i>","<i class='arrow_carrot-right'></i>"],responsive:{0:{nav:!1,dots:!0,items:1},768:{nav:!1,dots:!0,items:2},1024:{items:3}}}),e(".carousel_item").owlCarousel({center:!1,items:1,lazyLoad:!0,loop:!1,margin:0,dots:!1,nav:!0,navText:["<i class='arrow_carrot-left'></i>","<i class='arrow_carrot-right'></i>"]}),e(".panel-dropdown a").on("click",function(o){e(this).parent().is(".active")?a():(a(),e(this).parent().addClass("active")),o.preventDefault()});var t=!1;e(".panel-dropdown").hover(function(){t=!0},function(){t=!1}),e("body").mouseup(function(){t||a()}),e("ul#top_links > li").hover(function(){e(this).siblings().stop().fadeTo(300,.6),e(this).parent().siblings().stop().fadeTo(300,1)},function(){e(this).siblings().stop().fadeTo(300,1),e(this).parent().siblings().stop().fadeTo(300,1)}),e(".background-image").each(function(){e(this).css("background-image",e(this).attr("data-background"))})}(window.jQuery);




// JavaScript Document Faysal

function updateCartCount() {
            const cartItems = document.querySelectorAll('#cart_items > li[data-price]');
            const cartCountElement = document.getElementById('cart_count');
            cartCountElement.textContent = cartItems.length;
        }

        function removeItem(element) {
            const item = element.closest('li');
            const price = parseFloat(item.getAttribute('data-price'));
            const totalElement = document.getElementById('total_price');
            const currentTotal = parseFloat(totalElement.textContent.replace('$', ''));
            const newTotal = currentTotal - price;

            // Update the total price
            totalElement.textContent = `$${newTotal.toFixed(2)}`;

            // Remove the item from the cart
            item.remove();

            // Update the cart count
            updateCartCount();
        }

        function addItem(button) {
            // Logic to add an item (e.g., increment quantity or add a new item)
            alert('Ajouter un nouvel article - Fonctionnalité à implémenter');
        }

        // Initialize the cart count on page load
        document.addEventListener('DOMContentLoaded', updateCartCount);

      document.querySelector('.cart_bt').addEventListener('click', function(e) {
    e.preventDefault();
    const menu = document.getElementById('cart_items');
    if(menu.style.display === 'block') {
      menu.style.display = 'none';
    } else {
      menu.style.display = 'block';
    }
  });

  // Optionnel : cacher le menu quand on clique en dehors
  document.addEventListener('click', function(e) {
    const cart = document.querySelector('.dropdown-cart');
    if (!cart.contains(e.target)) {
      document.getElementById('cart_items').style.display = 'none';
    }
  });s