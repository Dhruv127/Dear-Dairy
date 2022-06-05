package com.example.mydiary.modules;


import androidx.cardview.widget.CardView;

import com.example.mydiary.modules.dairy;


public interface diareslistner
{
   void onclick(dairy dairy);
   void onlongclick(dairy dairy, CardView cardView);
}
