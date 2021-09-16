package br.ufjf.dcc196.matheus.criafichat20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class PersonagemAdapter extends RecyclerView.Adapter<PersonagemAdapter.PersonagemViewHolder>{
    private final List<Personagem> fichas;
    private OnPersonagemClickListener listener;

    public PersonagemAdapter(List<Personagem> fichas, OnPersonagemClickListener listener) {
        this.fichas = fichas;
        this.listener= listener;
    }

    @Override
    public PersonagemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View filmeView = inflater.inflate(R.layout.ficha_personagem_layout, parent, false);
        PersonagemViewHolder viewHolder = new PersonagemViewHolder(filmeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonagemAdapter.PersonagemViewHolder holder, int position){
        holder.textViewNome.setText(fichas.get(position).getNome());
        holder.textViewClasse.setText(fichas.get(position).getClasse());
        holder.textViewRaça.setText(fichas.get(position).getRaca());
        holder.textViewLevel.setText(String.valueOf(fichas.get(position).getNivel()));
        holder.textViewOrigem.setText(fichas.get(position).getOrigem());
        holder.textViewDivindade.setText(fichas.get(position).getDivindade());
        holder.textViewPvEdit.setText(String.valueOf(fichas.get(position).getPontosvida()));
        holder.textViewPmEdit.setText(String.valueOf(fichas.get(position).getPontosMana()));
        if(fichas.get(position).getDivindade()==""||fichas.get(position).getDivindade()==" "){
            holder.textView13.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return this.fichas.size();
    }

    public class PersonagemViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewRaça;
        private TextView textViewClasse;
        private TextView textViewLevel;
        private TextView textViewOrigem;
        private TextView textViewDivindade;
        private TextView textViewPvEdit;
        private TextView textViewPmEdit;
        private TextView textViewNome;
        private TextView textView13;

        public PersonagemViewHolder(View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewRaça = itemView.findViewById(R.id.textViewRaça);
            textViewClasse = itemView.findViewById(R.id.textViewClasse);
            textViewLevel = itemView.findViewById(R.id.textViewLevel);
            textViewOrigem = itemView.findViewById(R.id.textViewOrigem);
            textViewDivindade = itemView.findViewById(R.id.textViewDivindade);
            textViewPvEdit = itemView.findViewById(R.id.textViewPvEdit);
            textViewPmEdit = itemView.findViewById(R.id.textViewPmEdit);
            textView13 = itemView.findViewById(R.id.textView13);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    listener.onPersonagemClick(itemView,getAdapterPosition());
                }
            });
        }
    }

    public interface OnPersonagemClickListener{
        void onPersonagemClick(View view, int position);
    }
}

