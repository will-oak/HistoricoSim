package controller;

import javax.swing.JOptionPane;

import com.willoak.utils.pilha.string.Pilha;

public class HistoricoController {

	public HistoricoController() {
		
	}
	
	public void insertHistory(Pilha pilha, String url) {
		if (validateUrl(url)) {
			pilha.push(url);
			JOptionPane.showMessageDialog(null, "Site " + url + " inserido");
		} else {
			JOptionPane.showMessageDialog(null, "Site " + url + " inválido. A url deve seguir o exemplo: https://www.example.com");
		}
		
	}
	
	public void consultHistory(Pilha pilha) {
		try {
			JOptionPane.showMessageDialog(null, pilha.top());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Histórico vazio");
		}
		
	}
	
	public void removeHistory(Pilha pilha) {
		try {
			String item = pilha.pop();
			JOptionPane.showMessageDialog(null, "Site " + item + " removido");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Histórico vazio");
		}
	}
	
	public static boolean validateUrl(String url) {
		String[] dominios = new String[]{ ".com", ".br", ".org" };
		
		if (url.contains("http://") && url.contains("www.")) {
			int dominioCont = 0;
			
			for (int i = 0; i < dominios.length; i ++) {
				if (url.contains(dominios[i])) {
					dominioCont++;
				}
			}
			
			if (dominioCont == 0) {
				return false;
			}
			
		} else {
			return false;
		}
		
		return true;
	}

}
