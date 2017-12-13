package simpleModel;

import Objects.PatrolAgent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

/**
 * Created by Alexsandr0x.
 */
public class PatrolMain {
    private static final int GRID_SIZE = 30;

    static ContainerController containerController;
    static AgentController agentController;

    public static void main(String[] args) throws InterruptedException  {
        PatrolAgent agent = new PatrolAgent();
        //iniciando main container
        //startMainContainer(Profile.LOCAL_HOST, Profile.LOCAL_PORT, "UFABC");
        startMainContainer("127.0.0.1", Profile.LOCAL_PORT, "UFABC");
        //adicionando agente
        //SINTAXE: addAgent(container, nome_do_agente, classe, parametros de inicializacao)
        addAgent(containerController, "Patrol1", PatrolAgent.class.getName(), null );
        addAgent(containerController, "Patrol2", PatrolAgent.class.getName(), null );
        addAgent(containerController, "Patrol3", PatrolAgent.class.getName(), null );
        addAgent(containerController, "Patrol4", PatrolAgent.class.getName(), null );
    }

    static void startMainContainer(String host, String port, String name) {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST, host);
        profile.setParameter(Profile.MAIN_PORT, port);
        profile.setParameter(Profile.PLATFORM_ID, name);

        containerController = runtime.createMainContainer(profile);
    }

    static void addAgent(ContainerController cc, String agent, String classe, Object[] args) {
        try {
            agentController = cc.createNewAgent(agent, classe, args);
            agentController.start();
        } catch (StaleProxyException s) {
            s.printStackTrace();
        }
    }
}
