package com.example.mydiary.adapters;

import android.content.Context;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mydiary.R;
import com.example.mydiary.modules.dairy;
import com.example.mydiary.modules.diareslistner;

import org.w3c.dom.Text;

import java.util.List;

public class dairyadapter extends RecyclerView.Adapter<diaries_holder> {
    Context context;
    List<dairy> list;
    diareslistner listner;

    public dairyadapter(Context context, List<dairy> list, diareslistner listner) {
        this.context = context;
        this.list = list;
        this.listner = listner;
    }



    @NonNull
    @Override
    public diaries_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new diaries_holder(LayoutInflater.from(context).inflate(R.layout.diaries_listx,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull diaries_holder holder, int position) {
        holder.DATE.setText(list.get(position).getDate());
        holder.text.setText(list.get(position).getTitle());
        holder.text.setSelected(true);
        holder.diaries.setText(list.get(position).getDairy());

        holder.text.setSelected(true);


        holder.dairy_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onclick(list.get(holder.getAdapterPosition()));
            }
        });
        holder.dairy_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listner.onlongclick(list.get(holder.getAdapterPosition()), holder.dairy_container);

                return true;
            }
        });

        }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
class diaries_holder extends RecyclerView.ViewHolder
{

    CardView dairy_container;
    TextView text;
    TextView diaries;
    TextView DATE;
    public diaries_holder(@NonNull View itemView) {
        super(itemView);
        DATE=itemView.findViewById(R.id.date);
        dairy_container=itemView.findViewById(R.id.dairy_container);
        text=itemView.findViewById(R.id.text);
        diaries=itemView.findViewById(R.id.diaries);

    }
}
