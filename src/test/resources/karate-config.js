function fn() {
    var config = {
        baseUrl: 'https://reqres.in'
    };

    // Call Java class
    var My = Java.type('Utils.MyUtils');

    config.square = function(x) {
        return My.square(x);
    }
    return config;
}
