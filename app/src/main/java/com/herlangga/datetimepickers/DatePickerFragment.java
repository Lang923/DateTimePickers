package com.herlangga.datetimepickers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;

//Pada kode fragment dibuat untuk memproses Tanggal yang akan ditampilkan MainActivity
public class DatePickerFragment extends DialogFragment
    implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//    Gunakan tanggal saat ini sebagai tanggal default di alat pilih.
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

//        Buat instance baru DatePickerDialog dan kembalikan.
        return new DatePickerDialog(getActivity(), this,year,month,day);
    }

//    Ambil tanggalnya dan teruskan ke processDatePickerResult().
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
//      Ubah elemen tanggal menjadi string.
//      Atur aktivitas ke Aktivitas Utama.
        MainActivity activity = (MainActivity) getActivity();
// Memanggil metode processDatePickerResult() Aktivitas Utama.
        activity.processDatePickerResult(year, month, day);
    }
}