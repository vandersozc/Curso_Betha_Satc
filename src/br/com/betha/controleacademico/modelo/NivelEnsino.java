package br.com.betha.controleacademico.modelo;

public enum NivelEnsino {
	
	MEDIO {
		@Override
		public String toString() {
			return "Ensino_medio";
		}
	},
	FUNDAMENTAL {
		@Override
		public String toString() {
			return "Ensino_fundamental";
		}
	},
	TECNICO {
		@Override
		public String toString() {
			return "Tecnico";
		}
	},
	SUPERIOR {
		@Override
		public String toString() {
			return "Superior";
		}
	}

}
