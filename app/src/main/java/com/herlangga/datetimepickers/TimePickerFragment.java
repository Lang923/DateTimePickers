package com.herlangga.datetimepickers;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.widget.TimePicker;
import java.text.DateFormat;
import java.util.Calendar;

//Subkelas {@link Fragment} sederhana untuk pemilih waktu.
//Menetapkan waktu saat ini untuk pemilih menggunakan Kalender.
public class TimePickerFragment extends DialogFragment
    implements TimePickerDialog.OnTimeSetListener {
//  Membuat dialog pemilih waktu dengan waktu saat ini dari Kalender.

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//  Gunakan waktu saat ini sebagai nilai default untuk alat pilih.
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

//  Buat instance baru TimePickerDialog dan kembalikan.
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.getTimeInstance().isLenient());
    }

//  Ambil waktu dan ubah menjadi string untuk diteruskan
//  ke Aktivitas Utama untuk menampilkannya dengan processTimePickerResult().
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//  Atur aktivitas ke Aktivitas Utama
        MainActivity activity = (MainActivity) getActivity();
//  Panggil metode processTimePickerResult() Aktivitas Utama.
        activity.processTimePickerResult(hourOfDay, minute);
    }
}