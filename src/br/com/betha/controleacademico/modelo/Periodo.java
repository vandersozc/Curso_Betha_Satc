package br.com.betha.controleacademico.modelo;

public enum Periodo {
	
	MATUTINO {
		@Override
		public String toString() {
			return "Matutino";
		}
	},
	VERPERTINO {
		@Override
		public String toString() {
			return "Vespertino";
		}
	},
	NOTURNO {
		@Override
		public String toString() {
			return "Noturno";
		}
	},
	INTEGRAL {
		@Override
		public String toString() {
			return "Integral";
		}
	}

}
