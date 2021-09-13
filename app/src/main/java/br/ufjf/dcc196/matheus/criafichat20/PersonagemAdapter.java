package br.ufjf.dcc196.matheus.criafichat20;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonagemAdapter extends RecyclerView.Adapter<PersonagemAdapter.PersonagemViewHolder>{
    public PersonagemAdapter(List<Personagem> fichas) {
    }


    public PersonagemViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PersonagemAdapter.PersonagemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PersonagemViewHolder extends RecyclerView.ViewHolder {
        public PersonagemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
