package com.example.appsecurityanalyzer.dto;

public class AppDetailsDto {

    private String nombreApp;
    private double seguridad;

    //Registro
    private boolean registroConGoogle;
    private boolean registroConFacebook;
    private boolean pideNumeroTelefono;
    private boolean autenticaNumeroTelefono;
    private boolean pideCorreoElectronico;
    private boolean autenticaCorreoElectronico;
    private boolean longitudMinimaContrasena;
    private boolean longitudMaximaContrasena;
    private boolean obligaMinusculas;
    private boolean obligaMayusculas;
    private boolean obligaNumeros;
    private boolean obligaCaracteresEspeciales;
    private boolean permiteAutocompletarCampos;
    private boolean generaContrasenaAutomatica;
    private boolean permiteGuardarContrasena;
    private boolean pideConfirmacionContrasena;
    private boolean tienePasskeys;
    private boolean tieneCaptcha;

    //Login
    private boolean inicioSesionConGoogle;
    private boolean inicioSesionConFacebook;
    private boolean inicioSesionConNumeroTelefono;
    private boolean inicioSesionConCorreoElectronico;
    private boolean inicioSesionConNombreUsuario;
    private boolean inicioSesionConDatosBiometricos;
    private boolean tieneDobleFactorAutenticacion;
    private boolean preguntaDobleFactorAutenticacion;


    public AppDetailsDto(){}

    public AppDetailsDto(String nombreApp, double seguridad, boolean registroConGoogle, boolean registroConFacebook,
                         boolean pideNumeroTelefono, boolean autenticaNumeroTelefono, boolean pideCorreoElectronico,
                         boolean autenticaCorreoElectronico, boolean longitudMinimaContrasena, boolean longitudMaximaContrasena,
                         boolean obligaMinusculas, boolean obligaMayusculas, boolean obligaNumeros, boolean obligaCaracteresEspeciales,
                         boolean permiteAutocompletarCampos, boolean generaContrasenaAutomatica, boolean permiteGuardarContrasena,
                         boolean pideConfirmacionContrasena, boolean tienePasskeys, boolean tieneCaptcha,
                         boolean inicioSesionConGoogle, boolean inicioSesionConFacebook, boolean inicioSesionConNumeroTelefono,
                         boolean inicioSesionConCorreoElectronico, boolean inicioSesionConNombreUsuario,
                         boolean inicioSesionConDatosBiometricos, boolean tieneDobleFactorAutenticacion,
                         boolean preguntaDobleFactorAutenticacion) {
        this.nombreApp = nombreApp;
        this.seguridad = seguridad;
        this.registroConGoogle = registroConGoogle;
        this.registroConFacebook = registroConFacebook;
        this.pideNumeroTelefono = pideNumeroTelefono;
        this.autenticaNumeroTelefono = autenticaNumeroTelefono;
        this.pideCorreoElectronico = pideCorreoElectronico;
        this.autenticaCorreoElectronico = autenticaCorreoElectronico;
        this.longitudMinimaContrasena = longitudMinimaContrasena;
        this.longitudMaximaContrasena = longitudMaximaContrasena;
        this.obligaMinusculas = obligaMinusculas;
        this.obligaMayusculas = obligaMayusculas;
        this.obligaNumeros = obligaNumeros;
        this.obligaCaracteresEspeciales = obligaCaracteresEspeciales;
        this.permiteAutocompletarCampos = permiteAutocompletarCampos;
        this.generaContrasenaAutomatica = generaContrasenaAutomatica;
        this.permiteGuardarContrasena = permiteGuardarContrasena;
        this.pideConfirmacionContrasena = pideConfirmacionContrasena;
        this.tienePasskeys = tienePasskeys;
        this.tieneCaptcha = tieneCaptcha;
        this.inicioSesionConGoogle = inicioSesionConGoogle;
        this.inicioSesionConFacebook = inicioSesionConFacebook;
        this.inicioSesionConNumeroTelefono = inicioSesionConNumeroTelefono;
        this.inicioSesionConCorreoElectronico = inicioSesionConCorreoElectronico;
        this.inicioSesionConNombreUsuario = inicioSesionConNombreUsuario;
        this.inicioSesionConDatosBiometricos = inicioSesionConDatosBiometricos;
        this.tieneDobleFactorAutenticacion = tieneDobleFactorAutenticacion;
        this.preguntaDobleFactorAutenticacion = preguntaDobleFactorAutenticacion;
    }

    public String getNombreApp() {
        return nombreApp;
    }

    public void setNombreApp(String nombreApp) {
        this.nombreApp = nombreApp;
    }

    public double getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(double seguridad) {
        this.seguridad = seguridad;
    }

    public boolean getRegistroConGoogle() {
        return registroConGoogle;
    }

    public void setRegistroConGoogle(boolean registroConGoogle) {
        this.registroConGoogle = registroConGoogle;
    }

    public boolean getRegistroConFacebook() {
        return registroConFacebook;
    }

    public void setRegistroConFacebook(boolean registroConFacebook) {
        this.registroConFacebook = registroConFacebook;
    }

    public boolean getPideNumeroTelefono() {
        return pideNumeroTelefono;
    }

    public void setPideNumeroTelefono(boolean pideNumeroTelefono) {
        this.pideNumeroTelefono = pideNumeroTelefono;
    }

    public boolean getAutenticaNumeroTelefono() {
        return autenticaNumeroTelefono;
    }

    public void setAutenticaNumeroTelefono(boolean autenticaNumeroTelefono) {
        this.autenticaNumeroTelefono = autenticaNumeroTelefono;
    }

    public boolean getPideCorreoElectronico() {
        return pideCorreoElectronico;
    }

    public void setPideCorreoElectronico(boolean pideCorreoElectronico) {
        this.pideCorreoElectronico = pideCorreoElectronico;
    }

    public boolean getAutenticaCorreoElectronico() {
        return autenticaCorreoElectronico;
    }

    public void setAutenticaCorreoElectronico(boolean autenticaCorreoElectronico) {
        this.autenticaCorreoElectronico = autenticaCorreoElectronico;
    }

    public boolean getLongitudMinimaContrasena() {
        return longitudMinimaContrasena;
    }

    public void setLongitudMinimaContrasena(boolean longitudMinimaContrasena) {
        this.longitudMinimaContrasena = longitudMinimaContrasena;
    }

    public boolean getLongitudMaximaContrasena() {
        return longitudMaximaContrasena;
    }

    public void setLongitudMaximaContrasena(boolean longitudMaximaContrasena) {
        this.longitudMaximaContrasena = longitudMaximaContrasena;
    }

    public boolean getObligaMinusculas() {
        return obligaMinusculas;
    }

    public void setObligaMinusculas(boolean obligaMinusculas) {
        this.obligaMinusculas = obligaMinusculas;
    }

    public boolean getObligaMayusculas() {
        return obligaMayusculas;
    }

    public void setObligaMayusculas(boolean obligaMayusculas) {
        this.obligaMayusculas = obligaMayusculas;
    }

    public boolean getObligaNumeros() {
        return obligaNumeros;
    }

    public void setObligaNumeros(boolean obligaNumeros) {
        this.obligaNumeros = obligaNumeros;
    }

    public boolean getObligaCaracteresEspeciales() {
        return obligaCaracteresEspeciales;
    }

    public void setObligaCaracteresEspeciales(boolean obligaCaracteresEspeciales) {
        this.obligaCaracteresEspeciales = obligaCaracteresEspeciales;
    }

    public boolean getPermiteAutocompletarCampos() {
        return permiteAutocompletarCampos;
    }

    public void setPermiteAutocompletarCampos(boolean permiteAutocompletarCampos) {
        this.permiteAutocompletarCampos = permiteAutocompletarCampos;
    }

    public boolean getGeneraContrasenaAutomatica() {
        return generaContrasenaAutomatica;
    }

    public void setGeneraContrasenaAutomatica(boolean generaContrasenaAutomatica) {
        this.generaContrasenaAutomatica = generaContrasenaAutomatica;
    }

    public boolean getPermiteGuardarContrasena() {
        return permiteGuardarContrasena;
    }

    public void setPermiteGuardarContrasena(boolean permiteGuardarContrasena) {
        this.permiteGuardarContrasena = permiteGuardarContrasena;
    }

    public boolean getPideConfirmacionContrasena() {
        return pideConfirmacionContrasena;
    }

    public void setPideConfirmacionContrasena(boolean pideConfirmacionContrasena) {
        this.pideConfirmacionContrasena = pideConfirmacionContrasena;
    }

    public boolean getTienePasskeys() {
        return tienePasskeys;
    }

    public void setTienePasskeys(boolean tienePasskeys) {
        this.tienePasskeys = tienePasskeys;
    }

    public boolean getTieneCaptcha() {
        return tieneCaptcha;
    }

    public void setTieneCaptcha(boolean tieneCaptcha) {
        this.tieneCaptcha = tieneCaptcha;
    }

    public boolean getInicioSesionConGoogle() {
        return inicioSesionConGoogle;
    }

    public void setInicioSesionConGoogle(boolean inicioSesionConGoogle) {
        this.inicioSesionConGoogle = inicioSesionConGoogle;
    }

    public boolean getInicioSesionConFacebook() {
        return inicioSesionConFacebook;
    }

    public void setInicioSesionConFacebook(boolean inicioSesionConFacebook) {
        this.inicioSesionConFacebook = inicioSesionConFacebook;
    }

    public boolean getInicioSesionConNumeroTelefono() {
        return inicioSesionConNumeroTelefono;
    }

    public void setInicioSesionConNumeroTelefono(boolean inicioSesionConNumeroTelefono) {
        this.inicioSesionConNumeroTelefono = inicioSesionConNumeroTelefono;
    }

    public boolean getInicioSesionConCorreoElectronico() {
        return inicioSesionConCorreoElectronico;
    }

    public void setInicioSesionConCorreoElectronico(boolean inicioSesionConCorreoElectronico) {
        this.inicioSesionConCorreoElectronico = inicioSesionConCorreoElectronico;
    }

    public boolean getInicioSesionConNombreUsuario() {
        return inicioSesionConNombreUsuario;
    }

    public void setInicioSesionConNombreUsuario(boolean inicioSesionConNombreUsuario) {
        this.inicioSesionConNombreUsuario = inicioSesionConNombreUsuario;
    }

    public boolean getInicioSesionConDatosBiometricos() {
        return inicioSesionConDatosBiometricos;
    }

    public void setInicioSesionConDatosBiometricos(boolean inicioSesionConDatosBiometricos) {
        this.inicioSesionConDatosBiometricos = inicioSesionConDatosBiometricos;
    }

    public boolean getTieneDobleFactorAutenticacion() {
        return tieneDobleFactorAutenticacion;
    }

    public void setTieneDobleFactorAutenticacion(boolean tieneDobleFactorAutenticacion) {
        this.tieneDobleFactorAutenticacion = tieneDobleFactorAutenticacion;
    }

    public boolean getPreguntaDobleFactorAutenticacion() {
        return preguntaDobleFactorAutenticacion;
    }

    public void setPreguntaDobleFactorAutenticacion(boolean preguntaDobleFactorAutenticacion) {
        this.preguntaDobleFactorAutenticacion = preguntaDobleFactorAutenticacion;
    }

    @Override
    public String toString() {
        return "AppDetailsDto{" +
                "nombreApp='" + nombreApp + '\'' +
                ", seguridad='" + seguridad + '\'' +
                ", registroConGoogle=" + registroConGoogle +
                ", registroConFacebook=" + registroConFacebook +
                ", pideNumeroTelefono=" + pideNumeroTelefono +
                ", autenticaNumeroTelefono=" + autenticaNumeroTelefono +
                ", pideCorreoElectronico=" + pideCorreoElectronico +
                ", autenticaCorreoElectronico=" + autenticaCorreoElectronico +
                ", longitudMinimaContrasena=" + longitudMinimaContrasena +
                ", longitudMaximaContrasena=" + longitudMaximaContrasena +
                ", obligaMinusculas=" + obligaMinusculas +
                ", obligaMayusculas=" + obligaMayusculas +
                ", obligaNumeros=" + obligaNumeros +
                ", obligaCaracteresEspeciales=" + obligaCaracteresEspeciales +
                ", permiteAutocompletarCampos=" + permiteAutocompletarCampos +
                ", generaContrasenaAutomatica=" + generaContrasenaAutomatica +
                ", permiteGuardarContrasena=" + permiteGuardarContrasena +
                ", pideConfirmacionContrasena=" + pideConfirmacionContrasena +
                ", tienePasskeys=" + tienePasskeys +
                ", tieneCaptcha=" + tieneCaptcha +
                ", inicioSesionConGoogle=" + inicioSesionConGoogle +
                ", inicioSesionConFacebook=" + inicioSesionConFacebook +
                ", inicioSesionConNumeroTelefono=" + inicioSesionConNumeroTelefono +
                ", inicioSesionConCorreoElectronico=" + inicioSesionConCorreoElectronico +
                ", inicioSesionConNombreUsuario=" + inicioSesionConNombreUsuario +
                ", inicioSesionConDatosBiometricos=" + inicioSesionConDatosBiometricos +
                ", tieneDobleFactorAutenticacion=" + tieneDobleFactorAutenticacion +
                ", preguntaDobleFactorAutenticacion=" + preguntaDobleFactorAutenticacion +
                '}';
    }
}
