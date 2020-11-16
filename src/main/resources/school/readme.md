#50練習SQL

This is [an example](http://example.com/ "Title") inline link.




This is [50道練習題目](https://hackmd.io/9-8C-Xr5R-2e3lczlGMhDw#%E8%AA%B2%E7%A8%8B%E8%A1%A8 "50題練習") inline link.



# @RequestParam 
@RequestParam用來處理 Content-Type 為 application/x-www-form-urlencoded 編碼的內容，Content-Type 默認為該屬性。


# @RequestBody
註解@RequestBody接收的參數是來自requestBody中，即請求體。一般用於處理非 Content-Type: application/x-www-form-urlencoded編碼格式的數據，比如：application/json、application/xml等類型的數據。


# 後端解析json數據

上述示例是傳遞到實體類中的具體寫法，那麼如果傳遞到非實體類中，body裡面的json數據需要怎麼解析呢？我們再來看下面這個例子：

在body中，我們還是輸入上面的json數據，根據分析，上面的json數據是一個List數組內嵌套著map對象，那麼在後台的接收形式可寫為 List<Map<String, String>>，具體代碼如下圖所示：