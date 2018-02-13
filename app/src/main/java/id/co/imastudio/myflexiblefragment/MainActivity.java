package id.co.imastudio.myflexiblefragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Proses penempelan atau pemasangan obyek HomeFragment agar tampil kelayar */
        FragmentManager mFragmentManager = getSupportFragmentManager();
        // Api untuk melakukan operasi pada fragment seperti add(), replace(), commit() dsb.
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        // Proses penambahan fragment kedalam activity  dengan method add()
        HomeFragment mHomeFragment = new HomeFragment();
        mFragmentTransaction.add(R.id.frame_container, mHomeFragment, HomeFragment.class.getSimpleName());
        Log.d("MyFLexibleFragment", "Fragment name :"+HomeFragment.class.getSimpleName());
        // Menampilkan ke layar secara asynchronus dari objek mFragmentTransaction
        mFragmentTransaction.commit();
    }
}
