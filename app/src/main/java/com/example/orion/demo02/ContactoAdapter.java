package com.example.orion.demo02;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ViewHolderDatos> {
    List<Contacto> lista;

    public ContactoAdapter(List<Contacto> lista) {
        this.lista = lista;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView item;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            item=(TextView) itemView.findViewById(R.id.idDato);
        }

        public void asignarDator(Contacto contacto) {
            item.setText(contacto.toString());
        }
    }
    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contacto,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.asignarDator(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

}
