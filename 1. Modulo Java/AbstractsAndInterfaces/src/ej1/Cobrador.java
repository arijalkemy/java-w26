package ej1;

public class Cobrador extends Cliente{
        @Override
        public void depositar() {
            new Deposito().transaccionNoOk();
        }

        @Override
        public void transferir() {
            new Transferencia().transaccionNoOk();
        }

        @Override
        public void retirarEfectivo() {
            new RetiroEfectivo().transaccionOk();
        }

        @Override
        public void consultarSaldo() {
            new ConsultaSaldo().transaccionOk();
        }

        @Override
        public void pagarServicios() {
            new PagoServicios().transaccionNoOk();
        }
}
