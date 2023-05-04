package com.example.affirmations

import android.os.Bundle
import android.widget.Adapter
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //need to use your Datasource and ItemAdapter classes to create and display items in the RecyclerView
        val myDataset = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ItemAdapter(this, myDataset)

        //Assign the ItemAdapter object to the adapter property of the recyclerView
        recyclerView.adapter= adapter

        //Since the layout size of your RecyclerView is fixed in the activity layout, you can set the setHasFixedSize parameter of the RecyclerView to true. This setting is only needed to improve performance. Use this setting if you know that changes in content do not change the layout size of the RecyclerView.
        recyclerView.setHasFixedSize(true)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AffirmationsTheme {
        Greeting("Android")
    }
}
