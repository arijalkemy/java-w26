# Enunciado 

Al momento de crear la clase Automovil se han cometido algunos errores en su diseño. ¿Puedes identificarlos y corregirlos siguiendo lo que has aprendido acerca de ellas?

## Código original
``` 
    public automovil {
        
        String marca;
        String color;
        double kilometros;

        public Automovil() {

        }

        public Automovil(marca, color, kilometros) {
                this.marca = marca;
                this.color = color;
                this.kilometros = kilometros;
        }

        public String mostrarMarcaYColor() {
                String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
        }
    }
```