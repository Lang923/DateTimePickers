package com.herlangga.datetimepickers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//Aplikasi ini menunjukkan pemilih waktu dan tanggal ketika Anda mengklik tombol yang sesuai.
public class MainActivity extends AppCompatActivity {

//    Membuat tampilan berdasarkan tata letak aktivitas utama.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //  Code Untuk menapilkan Tanggal yang didapat dari DatePickerFragment
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),
                getString(R.string.date_picker));

    }

    //    Code Untuk menapilkan Waktu yang didapat dari DatePickerFragment
    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),
                getString(R.string.time_picker));
    }
//    Code untuk memproses Tanggal yang didapat dari Fragment yang dibuat di dataOnSet di fragment
//    pada kode month di +1 dikarenakan pada bulan dihitung dari 0 maka ditambah 1 agar dimulai dari bulan 1
    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (month_string + "/" +
                day_string + "/" + year_string);

        Toast.makeText(this, getString(R.string.date) + dateMessage,
                Toast.LENGTH_SHORT).show();
    }

    //    Code untuk memproses Waktu yang didapat dari Fragment yang dibuat di dataOnSet di fragment
    public void processTimePickerResult(int hourOfDay, int minute) {
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        String timeMessage = (hour_string + ":" + minute_string);
        Toast.makeText(this, getString(R.string.time) + timeMessage,
                Toast.LENGTH_SHORT).show();

    }

}