package ej1;

public class Ejecutivo extends Cliente{
        @Override
        public void depositar() {
            new Deposito().transaccionOk();
        }

        @Override
        public void transferir() {
            new Transferencia().transaccionOk();
        }

        @Override
        public void retirarEfectivo() {
            new RetiroEfectivo().transaccionNoOk();
        }

        @Override
        public void consultarSaldo() {
            new ConsultaSaldo().transaccionNoOk();
        }

        @Override
        public void pagarServicios() {
            new PagoServicios().transaccionNoOk();
        }
}
