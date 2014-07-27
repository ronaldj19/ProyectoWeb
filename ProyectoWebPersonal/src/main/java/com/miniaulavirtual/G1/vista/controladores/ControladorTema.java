package com.miniaulavirtual.G1.vista.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.miniaulavirtual.G1.datos.dominio.persistencia.dao.UsuarioDAO;

@ManagedBean(name = "temas")
@ViewScoped
public class ControladorTema {

	private List<String> themes;

	@EJB
	private UsuarioDAO usuarioDao;

	@ManagedProperty("#{loginBean}")
	private ControladorLogin controlLogin;

	@PostConstruct
	public void init() {
		themes = new ArrayList<String>();
		themes.add("afterdark");
		themes.add("afternoon");
		themes.add("afterwork");
		themes.add("aristo");
		themes.add("black-tie");
		themes.add("blitzer");
		themes.add("bluesky");
		themes.add("bootstrap");
		themes.add("casablanca");
		themes.add("cruze");
		themes.add("cupertino");
		themes.add("dark-hive");
		themes.add("delta");
		themes.add("dot-luv");
		themes.add("eggplant");
		themes.add("excite-bike");
		themes.add("flick");
		themes.add("glass-x");
		themes.add("home");
		themes.add("hot-sneaks");
		themes.add("humanity");
		themes.add("le-frog");
		themes.add("midnight");
		themes.add("mint-choc");
		themes.add("overcast");
		themes.add("pepper-grinder");
		themes.add("redmond");
		themes.add("rocket");
		themes.add("sam");
		themes.add("smoothness");
		themes.add("south-street");
		themes.add("start");
		themes.add("sunny");
		themes.add("swanky-purse");
		themes.add("trontastic");
		themes.add("ui-darkness");
		themes.add("ui-lightness");
		themes.add("vader");

		System.out.println("Inicializando");
		System.out.println(themes.size() + " items");
	}

	public void guardarTema() {
		usuarioDao.actualizar(controlLogin.getUsuario());
	}

	public List<String> getThemes() {
		return themes;
	}

	public ControladorLogin getControlLogin() {
		return controlLogin;
	}

	public void setControlLogin(ControladorLogin controlLogin) {
		this.controlLogin = controlLogin;
	}
}