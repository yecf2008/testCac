package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Bri QQ1072307340
 *
 */
public class MainActivity extends Activity implements OnClickListener {
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bp, bs, bm, bd, bc, be;
	ImageView delete;
	TextView tv;
	EditText show;
	String showString = "", option = "";
	int showfirst = 0;
	String exception = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		b0 = (Button) findViewById(R.id.bt_0);
		b1 = (Button) findViewById(R.id.bt_1);
		b2 = (Button) findViewById(R.id.bt_2);
		b3 = (Button) findViewById(R.id.bt_3);
		b4 = (Button) findViewById(R.id.bt_4);
		b5 = (Button) findViewById(R.id.bt_5);
		b6 = (Button) findViewById(R.id.bt_6);
		b7 = (Button) findViewById(R.id.bt_7);
		b8 = (Button) findViewById(R.id.bt_8);
		b9 = (Button) findViewById(R.id.bt_9);
		bp = (Button) findViewById(R.id.bt_plus);
		bs = (Button) findViewById(R.id.bt_sub);
		bm = (Button) findViewById(R.id.bt_mutilate);
		bd = (Button) findViewById(R.id.bt_div);
		bc = (Button) findViewById(R.id.bt_c);
		be = (Button) findViewById(R.id.bt_equ);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b9.setOnClickListener(this);
		b0.setOnClickListener(this);
		bp.setOnClickListener(this);
		bs.setOnClickListener(this);
		bm.setOnClickListener(this);
		bd.setOnClickListener(this);
		bc.setOnClickListener(this);
		be.setOnClickListener(this);
		show = (EditText) findViewById(R.id.et_show);
		delete = (ImageView) findViewById(R.id.iv_delete);
		delete.setOnClickListener(this);
		tv = (TextView) findViewById(R.id.author);
		tv.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_0:

			showString += "0";
			break;
		case R.id.bt_1:
			showString += "1";
			break;
		case R.id.bt_2:
			showString += "2";
			break;
		case R.id.bt_3:
			showString += "3";
			break;
		case R.id.bt_4:
			showString += "4";
			break;
		case R.id.bt_5:
			showString += "5";
			break;
		case R.id.bt_6:
			showString += "6";
			break;
		case R.id.bt_7:
			showString += "7";
			break;
		case R.id.bt_8:
			showString += "8";
			break;
		case R.id.bt_9:
			showString += "9";
			break;
		case R.id.bt_plus:
			if (showString.equals(""))
				exception = "先输入数值哦";

			else {
				showfirst = Integer.parseInt(showString);
				showString = "";
				option = "+";
			}
			break;
		case R.id.bt_sub:

			if (showString.equals(""))
				exception = "先输入数值哦";
			else {
				showfirst = Integer.parseInt(showString);
				showString = "";

				option = "-";
			}
			break;
		case R.id.bt_mutilate:

			if (showString.equals(""))
				exception = "先输入数值哦";
			else {
				showfirst = Integer.parseInt(showString);
				showString = "";
				option = "*";
			}
			break;
		case R.id.bt_div:

			if (showString.equals(""))
				exception = "先输入数值哦";
			else {
				showfirst = Integer.parseInt(showString);
				showString = "";
				option = "/";
			}
			break;
		case R.id.bt_equ:
			if (option.equals("+"))
				showString = showfirst + Integer.parseInt(showString) + "";
			else if (option.equals("-")) {
				showString = showfirst - Integer.parseInt(showString) + "";
			} else if (option.equals("*")) {
				showString = showfirst * Integer.parseInt(showString) + "";
			} else if (option.equals("/")) {
				if (showString.equals("0")) {
					exception = "除数不能为0！";
				} else
					showString = showfirst / Integer.parseInt(showString) + "";
			}

			break;
		case R.id.bt_c:
			showString = "";

			break;

		case R.id.iv_delete:

			Toast.makeText(MainActivity.this, showString + "已被清空",
					Toast.LENGTH_SHORT).show();
			showString = "";
			break;
		case R.id.author:

			Toast.makeText(MainActivity.this, "郑明亮\n软件工程\nQQ：1072307340",
					Toast.LENGTH_SHORT).show();

			break;
		default:
			break;
		}
		if (exception.equals(""))
			show.setText(showString);
		else {
			show.setText(exception);
			exception = "";
		}
		// 设置文本框颜色；
		if (!show.getText().toString().equals("")) {
			delete.setBackgroundColor(R.drawable.delete_gray);
		}

		else {
			delete.setBackgroundResource(R.drawable.delete);

		}

	}
}
