package com.cabrera.misnotas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.cabrera.misnotas.Model.Person;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<Person> mValues;

    public Adapter(List<Person> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mCarnet.setText(mValues.get(position).getCarnet());
        holder.mNota.setText(mValues.get(position).getNota()+"");
        holder.mCatedratico.setText(mValues.get(position).getCatedratico());
        holder.mMateria.setText(mValues.get(position).getMateria());
    }

    @Override
    public int getItemCount() {
        try{
            return mValues.size();
        }
        catch (Exception e){
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mCarnet;
        public final TextView mNota;
        public final TextView mCatedratico;
        public final TextView mMateria;
        public Person mItem;

        public ViewHolder(View view) {
            super(view);
            mCarnet = (TextView) view.findViewById(R.id.ShowCarnet);
            mNota = (TextView) view.findViewById(R.id.ShowNota);
            mCatedratico = (TextView) view.findViewById(R.id.ShowCatedratico);
            mMateria = (TextView) view.findViewById(R.id.ShowMateria);
        }


    }
}