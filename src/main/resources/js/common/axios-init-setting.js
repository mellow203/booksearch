var axiosUtils = (function() {

  // String.format 은 axiosUtils 와 무관한 기능이나 편의성을 위한 메소드 추가
  /**
   * String.format
   *   ex) '안녕하세요. {0}님'.format('홍길동') === '안녕하세요. 홍길동님'
   *   ex) '{0}el{1}ome {2}o ad{0}i{2}{2}'.format('w', 'c', 't') === 'welcome to adwitt'
   *   ex) '{0:name}님! 나이는 {1:나이}살 입니다.'.format('홍길동', 100) === '홍길동님! 나이는 100살 입니다.'
   * 코멘트 사용은 (영문, 숫자, _, 한글)만 지원됩니다.
   */
  String.prototype.format = function() {
    var args = arguments;
    return this.replace(/{(\d+)(:[\wㄱ-힣]+)?}/g, function(match, number) {
      return typeof args[ number ] !== undefined ? args[ number ] : match;
    });
  };

  // axios 기본 세팅
  _setInterceptors(axios);

  function _setInterceptors(_axios) {
    ////localhost api test
    var localApiService = '/reports-service';
    var localhost = 'http://localhost:8080';
    _axios.interceptors.request.use(function (config) {
      if (config.url.match(localApiService) !== null) {
        config.baseURL = localhost;
        //config.url = config.url.replace(localApiService, '');
      }
      return config;
    });


    _axios.interceptors.request.use(function(config) {
      var token = getTokenParam();
      if (token) {
        if (!config.params) {
          config.params = { token };
        } else if (!config.params.token) {
          config.params.token = token;
        }
      }
      return config;
    });
    _axios.interceptors.response.use(function(response) {
      return response.data;
    }, function(error) {
      return Promise.reject(error);
    });
  }

  function getTokenParam() {
    var token = 'token'.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + token + '=([^&#]*)'),
      results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[ 1 ].replace(/\+/g, ' '));
  }

  var _axios;

  /** @return axios */
  function baseUrl(url) {
    console.log("22");
    if (_axios) {
      _axios.defaults.baseURL = url;
      return _axios;
    }
    _axios = axios.create({
      baseURL: url,
    });
    _setInterceptors(_axios);
    return _axios;
  }

  // public function
  return {
    baseUrl: baseUrl,
  };

}());
