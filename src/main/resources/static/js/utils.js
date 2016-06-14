/**
 * Created by Sebastian on 13-Jun-16.
 */
// Extract some information from the cookies
function showMeYourCookies(title) {
    var jsessionid = Cookies.get('JSESSIONID');
    if (jsessionid) {
        console.log('>>>>> ' + title + ' JSESSIONID cookie = ' + jsessionid);
    } else {
        console.warn('>>>>> ' + title + ' no JSESSIONID cookie was found');
    }

    var restsecurity = Cookies.get('helloween');
    if (restsecurity) {
        restsecurity = JSON.parse(restsecurity);
        console.log('>>>>> ' + title + ' restsecurity cookie = ' + restsecurity);
    } else {
        console.warn('>>>>> ' + title + ' no restsecurity cookie was found');
    }
}

// Extract some info from the returned jqXHR
function showMeYourJqXHR(title, jqXHR) {
    if (jqXHR) {
        console.log('>>>>> ' + title + ' jqXHR X-CSRF-TOKEN = ' + jqXHR.getResponseHeader('X-CSRF-TOKEN'));
    } else {
        console.error('>>>>> ' + title + ' no jqXHR is defined... That\'s not normal at all...');
    }
}