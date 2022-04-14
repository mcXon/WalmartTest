package com.example.walmarttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walmarttest.view.ProductListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            loadProductListFragment()
    }

    private fun loadProductListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, ProductListFragment())
            .commit()
    }
}
//https://mobile-tha-server.firebaseapp.com/walmartproducts/2/1

/*
{
  "products":[
    {
      "productId":"003e3e6a-3f84-43ac-8ef3-a5ae2db0f80e",
      "productName":"Ellerton TV Console",
      "shortDescription":"<p><span style=\"color:#FF0000;\"><b>White Glove Delivery Included</b></span></p>\n\n<ul>\n\t<li>Excellent for the gamer, movie enthusiest, or interior decorator in your home</li>\n\t<li>Built-in power strip for electronics</li>\n\t<li>Hardwood solids and cherry veneers</li>\n</ul>\n",
      "longDescription":"<p>The Ellerton media console is well-suited for today&rsquo;s casual lifestyle. Its elegant style and expert construction will make it a centerpiece in any home. Soundly constructed, the Ellerton uses hardwood solids &amp; cherry veneers elegantly finished in a rich dark cherry finish. &nbsp;With ample storage for electronics &amp; media, it also cleverly allows for customization with three choices of interchangeable door panels.</p>\n",
      "price":"$949.00",
      "productImage":"/images/image2.jpeg",
      "reviewRating":2,
      "reviewCount":1,
      "inStock":true
    }
  ],
  "totalProducts":224,
  "pageNumber":1,
  "pageSize":1,
  "statusCode":200
}
 */