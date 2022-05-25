package com.stapf.campominado.celula;

public enum Status {

    /**
     * Célula está aguardando um clique com o botão primário do mouse.
     */
    AGUARDANDO,

    /**
     * Célula foi ativada através do botão primário do mouse.
     */
    ATIVADA,

    /**
     * Célula incapaz de receber um clique com o botão primaŕio do mouse.
     */
    BLOQUEADA;
}
