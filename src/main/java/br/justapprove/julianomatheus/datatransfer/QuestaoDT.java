package br.justapprove.julianomatheus.datatransfer;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class QuestaoDT {
    @Getter @Setter private byte[] descricao;
    @Getter @Setter private List<AlternativaDT> alternativaDT;
}