package namor;

import java.io.IOException;

import org.apache.commons.net.telnet.TelnetClient;

public class NamorTelnet {

	private TelnetClient telnet;

	public NamorTelnet() {
		telnet = new TelnetClient();
	}

	/**
	 * Método para conectar um servidor via Telnet, não faz ação alguma, apenas
	 * verifica se conectou ou não.
	 * 
	 * @param ip
	 * @param porta
	 * @return
	 */
	public boolean conectarServidor(String ip, int porta) {

		System.out.println("Conectado em " + ip + ":" + porta);

		try {
			if (telnet == null) {
				telnet = new TelnetClient();
			}

			telnet.connect(ip, porta);

			if (telnet.isConnected()) {
				System.out.println("Conectou!");
				return true;
			}

			System.out.println("Não conectou!");
			return false;
		} catch (Exception ex) {
			return false;
		} finally {
			desconectar(this.telnet);
		}
	}

	private void desconectar(TelnetClient telnet) {
		try {
			if (this.telnet.isConnected() || this.telnet != null) {
				this.telnet.disconnect();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			telnet = null;
			System.out.println("Desconectou");
		}
	}

}
