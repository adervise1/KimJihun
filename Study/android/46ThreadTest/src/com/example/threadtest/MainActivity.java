package com.example.threadtest;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	int bCount,tCount;
	TextView txtA,txtB;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtA=(TextView)findViewById(R.id.textView1);
        txtB=(TextView)findViewById(R.id.textView2);
        findViewById(R.id.button1).setOnClickListener(
        		new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bCount++;
				txtA.setText("bCount��:"+bCount);
				txtB.setText("tCount��:"+tCount);
			}
		});
        
        //thread ó��
        //��� 1
//        ThreadClass class1=new ThreadClass();
//        class1.setDaemon(true);//���ν����� ����� ����� �����嵵 �Բ� ����
//        class1.start();
        
        //��� 2
//        RunnableClass class1=new RunnableClass();
//        Thread thread=new Thread(class1);
//        thread.setDaemon(true);
//        thread.start();
        
        //��� 3
      HandlerClass class1=new HandlerClass();
      class1.setDaemon(true);//���ν����� ����� ����� �����嵵 �Բ� ����
      class1.start();
    }
    
    //��� 1
    class ThreadClass extends Thread
    {
    	@Override
    	public void run() {
    		while(true)
    		{
    			tCount++;
    			//���� Thread �������� ���ν����� UI �� ���������� �����Ҽ� ����
    			//txtB.setText("tCount ��:"+tCount);
    			try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    }
    
    //��� 2
    class RunnableClass implements Runnable
    {
    	@Override
    	public void run() {
    		while(true)
    		{
    			tCount++;
    			//���� Thread �������� ���ν����� UI �� ���������� �����Ҽ� ����
    			//txtB.setText("tCount ��:"+tCount);
    			try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}	
    	}
    }
    
    //��� 3
    //��׶���� ���׶��� ������ ���� ����� �����ϰ� ��
    Handler handler=new Handler(){
    	public void handleMessage(android.os.Message msg) {
    		if(msg.what==3){
    			txtB.setText("tCount ��:"+tCount);
    		}
    	};
    };

    class HandlerClass extends Thread
    {
    	@Override
    	public void run() {
    		while(true)
    		{
    			tCount++;
    			//���� Thread �������� ���ν����� UI �� ���������� �����Ҽ� ����
    			//txtB.setText("tCount ��:"+tCount);
    			
    			handler.sendEmptyMessage(3);//what �� 3 ���޵�
    			try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}