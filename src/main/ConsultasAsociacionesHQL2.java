package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.SessionFactoryUtil;

import java.util.List;

public class ConsultasAsociacionesHQL2 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		{
			System.out.println(
					"----------- Q1: Los nombres de los departamentos que "
					+ "no tengan empleados ordenados por nombre -----------");
			List<String> deptList = session
					.createQuery("")
//
					.list();

			for (String deptNombre : deptList) {
				System.out.println("Nombre: " + deptNombre);
			}

		}

		{

			System.out.println(
					"----------- Q2: Los nombres de los departamentos y de los empleados que tienen al menos 2 empleados ordenados por nombre de depto -----------");
			List<Object[]> deptList = session.
					createQuery("")
					.list();

			for (Object[] filas : deptList) {
				System.out.println("Nombre depto: " + filas[0] + " Nombre emp: " + filas[1]);
			}

		}

		{

			System.out.println("----------- Q3: Los ids de los empleados y el nº de cuentas por empleado -----------");
			List<Object[]> deptList = session
					.createQuery("  ").list();

			for (Object[] filas : deptList) {
				System.out.println("Id emp: " + filas[0] + " Nº de cuentas: " + filas[1]);
			}

		}

		{

			System.out.println("----------- Q4: Los ids de los empleados y el saldo de sus cuentas -----------");
			List<Object[]> deptList = session
					.createQuery("")
					.list();

			for (Object[] filas : deptList) {
				System.out.println("Id emp: " + filas[0] + " Saldo cuenta(s): " + filas[1]);
			}

		}

		{
			System.out.println("5.El identificador de cada cuenta con el identificador del movimiento donde la cuenta es la cuenta origen");
			List<Object[]> lista=session.createQuery(
					""
					//  "select accountOrigen.accountno, accountMovId from AccMovement"
			).list();

			for (Object[] e:lista) {
				System.out.println("Identificador cuenta: "+e[0]+ " Identificador de movimiento: "+e[1]);
			}



		}

		{
			System.out.println("6.El nº de movimientos por cada cuenta origen");
			List<Object[]> lista=session.createQuery(
					"").list();
			//"SELECT a.accountno, SIZE(a.accMovementsOrigen) FROM Account a WHERE SIZE(a.accMovementsOrigen)>0"
			for (Object[] e:lista) {
				System.out.println("Numero Cuenta: "+e[0]+" Numero de Movimientos "+e[1]);
			}



		}

		{
			System.out.println("7. El nombre de cada empleado con el de su jefe. Ha de aparecer el nombre del empleado aunque no tenga jefe");
			List<Object[]> lista=session.createQuery("").list();
			for (Object[] e:lista) {
				System.out.println("Nombre del empleado: "+e[0]+", su jefe es: "+e[1]);
			}


		}
		
				
		session.close();
		sessionFactory.close();
	}
}
