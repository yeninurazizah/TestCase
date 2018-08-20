package id.co.asyst.yeni.learnfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CARA PAKAI TOPIC
        FirebaseMessaging.getInstance().subscribeToTopic("training");
        //kalo mau unsubscribe
//        FirebaseMessaging.getInstance().unsubscribeFromTopic("training");

    }
}
