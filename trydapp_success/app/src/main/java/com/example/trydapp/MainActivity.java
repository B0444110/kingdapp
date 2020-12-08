package com.example.trydapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.Tuple;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    public static Admin admin;
    public static Credentials credentials;
    public BigInteger price;
    public static KingOfCountry kingOfCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button_send);
        Button king = findViewById(R.id.button2);
        TextView account_str = findViewById(R.id.text);
        EditText king_price = findViewById(R.id.editText);

        //連線到區塊鏈Server及區塊鏈帳號
        admin = Admin.build(new HttpService("http://10.0.2.2:8545"));
        credentials = Credentials.create("cfa093d87172345071d83f87bb30088db9b79c4cf25f8d2b217be920191dfee9");

        account_str.setText("地址：" + credentials.getAddress().toString());


        //連接合約設定
        setContract();

        //按下"註冊"按鈕
        button.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, king_price.getText(), Toast.LENGTH_SHORT).show();

                //BigInteger dec_num = Convert.toWei(new BigDecimal(account_str.toString()), Convert.Unit.ETHER).toBigInteger();

                BigInteger dec_num = Convert.toWei(new BigDecimal(king_price.getText().toString()), Convert.Unit.ETHER).toBigInteger();
                BigInteger price_in_contract = null;//抓目前合約國王價格

                //price = BigInteger.valueOf(Long.parseLong(king_price.getText().toString()));
                try {
                    price_in_contract = kingOfCountry.price().sendAsync().get();
                    kingOfCountry.becomeking(dec_num).sendAsync().get();
                    //TransactionReceipt result = MainActivity.kingOfCountry.becomeking(price).sendAsync().get();


                } catch (ExecutionException e) {

                    e.printStackTrace();
                    //account_str.setText("1:"+e.toString());
                    Toast.makeText(MainActivity.this, "目前price為"+price_in_contract.toString(), Toast.LENGTH_SHORT).show();

                } catch (InterruptedException e) {

                    e.printStackTrace();
                    //account_str.setText("2:"+e.toString());
                }
            }
        });


        king.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {
                    account_str.setText(kingOfCountry.king().sendAsync().get());

                    //Toast.makeText(MainActivity.this, "未購買", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    ;

    //連接合約設定
    public void setContract() {

        BigInteger GAS_PRICE = BigInteger.valueOf(15_000_000_000L);
        BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000L);
        String contractAddr = "0xfeebd407f5e164a371c33d6b91bf3f5ee0d4dcce";

        kingOfCountry = KingOfCountry.load(
                contractAddr,
                admin,
                credentials,
                GAS_PRICE,
                GAS_LIMIT);

    }
}


