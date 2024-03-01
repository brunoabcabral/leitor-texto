package com.brcabral.reuniaoimp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.content.Context;
import java.content.res.AssetManager;
import java.view.View;
import java.widget.Button;
import java.widget.TextView;
import java.support.v7.app.AppCompatActivity;
import java.os.Bundle;
/*author Bruno Alexandre botto Cabral alencar*/
public class MainActivity extends AppCompatActivity {

    private Button charge;
    private TextView read;
    private Context context;
    private ArrayList<String> Arquivos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        read = (TextView) findViewById(R.id.txtread);
        charge = (Button) findViewById(R.id.btncharge);
        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readAndDisplay();
            }
        });
    }

            private void readAndDisplay () {
                AssetManager mgr = this.context.getAssets();
                String filename = null;

                try {
                    filename = "proposals.txt";
                    System.out.println("filename : " + filename);
                    InputStream in = mgr.open(filename, AssetManager.ACCESS_BUFFER);
                    String sHTML = StreamToString(in);
                    in.close();

                    read.setText(sHTML);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private String StreamToString (InputStream in){
                if (in == null) {
                    return "";
                }
                Writer writer = new StringWriter();
                char[] buffer = new char[1024];
                try {
                    Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                    int n;
                    while ((n = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, n);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
                return writer.toString();
            }

}

