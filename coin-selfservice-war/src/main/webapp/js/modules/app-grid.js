var app = app || {};

app.appgrid = function() {
    var gridElm;

    var init  = function() {
        gridElm = $('.app-grid');

        if (gridElm.length === 0) {
            return;
        }

        gridElm.addClass('app-grid-js');

        setHover();
        setSearch();
    };


    var setHover = function() {
        gridElm.find('li').click(function(e) {
            var elm = $(this),
                target = $(e.target);

            if (target.is('a') || target.closest('a').length === 1) {
                return;
            }

            e.preventDefault();

            var link = elm.find('h2 a');

            location.href = link.attr('href');
        });
    };


    var setSearch = function() {
        var placeholderText = app.message.i18n('appgrid.search.placeholder'),
            hasLicenseText = app.message.i18n('appgrid.filter.haslicense'),
            isConnectedText = app.message.i18n('appgrid.filter.isconnected'),
            filters = '';

        if (gridElm.hasClass('filters-available')) {
        	filters = '<div>' + 
        				'<ul>';
            if (gridElm.hasClass('lmng-active')) {
            	filters += '<li><a href="#" data-filter="licensed"><i class="icon-shopping-cart"></i> ' + hasLicenseText + '</a></li>'
            }
            filters += '<li><a href="#" data-filter="connected"><i class="icon-check"></i> ' + isConnectedText + '</a></li>' +
                      '</ul>' +
                    '</div>';
        }

        gridElm.before('<nav class="filter-grid' + (gridElm.hasClass('filters-available') ? ' filters-available' : '') + '">' +
                           '<input type="search" class="app-grid-search" placeholder="' + placeholderText + '">' +
                           filters +
                       '</nav>');

        var searchElm = $('.app-grid-search'),
            filterLinks = $('.filter-grid a'),
            timer = null,
            activeFilters = [];


        function setTimer() {
            if (timer) {
                clearTimeout(timer);
            }
            timer = setTimeout(doSearch, 100);
        }


        function doSearch() {
            var isSearch = searchElm.val().length !== 0,
                keywords = [];

            if (isSearch) {
                keywords = searchElm.val().toLowerCase().split(' ');
            }

            gridElm.find('li').each(function(index, elm) {
                var $elm = $(elm),
                    display = true,
                    text = elm.textContent.toLowerCase() || elm.innerText.toLowerCase();

                $.each(keywords, function(i, kw) {
                    if (display === false) {
                        return;
                    }

                    display = false;

                    if (text.indexOf(kw) !== -1) {
                        display = true;
                    }
                });

                $.each(activeFilters, function(i, filter) {
                    if (display === false) {
                        return;
                    }

                    display = false;

                    if ($elm.hasClass(filter)) {
                        display = true;
                    }
                });

                if (display) {
                    $elm.removeClass('hide');
                }
                else {
                    $elm.addClass('hide');
                }
            });
        }

        function doFilter(e) {
            e.preventDefault();

            var clickedFilter = $(this),
                theFilter = clickedFilter.data('filter'),
                index = $.inArray(theFilter, activeFilters);

            if (index === -1) {
                activeFilters.push(theFilter);
                clickedFilter.addClass('active-filter');
            }
            else {
                activeFilters.splice(index, 1);
                clickedFilter.removeClass('active-filter');
            }

            doSearch();
        }

        searchElm.bind('keyup change', setTimer);
        filterLinks.on('click', doFilter);
    };


    return {
        init: init
    };
}();

app.register(app.appgrid);