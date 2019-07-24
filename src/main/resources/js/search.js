var search = (function() {



  function bookList() {
    axios.get('/book/search/{0:keyword}'.format($("#keyword").val()))
      .then(function(res) {
        $("#book_list li").remove();
        console.log(res);
        var data = res.documents;
        var html ="";

        for(var i in data){
          html += "<li id='detail_'+title>"+data[i].title+"</li>";
        }
        $("#book_list").append(html);
        $('#book_list').pagination({
          dataSource: [1, 2, 3, 4, 5, 6, 7]
        })
      });
  }

  return {
    bookList: bookList,
  };
}());