



public final class IdentityKit {

    public static void unpackConfig(JagexArchive jagexArchive)
    {
        Packet stream = new Packet(jagexArchive.getDataForName("idk.dat"));
        length = stream.g2();
        if(cache == null)
            cache = new IdentityKit[length];
        for(int j = 0; j < length; j++)
        {
            if(cache[j] == null)
                cache[j] = new IdentityKit();
            cache[j].readValues(stream);
        }
    }

    private void readValues(Packet stream)
    {
        do
        {
            int opcode = stream.g1();
            if(opcode == 0)
                return;
            if(opcode == 1)
                bodyPartID = stream.g1();
            else
            if(opcode == 2)
            {
                int modelCount = stream.g1();
                bodyModelIDs = new int[modelCount];
                for(int ptr = 0; ptr < modelCount; ptr++)
                    bodyModelIDs[ptr] = stream.g2();

            } else
            if(opcode == 3)
                notSelectable = true;
            else
            if(opcode >= 40 && opcode < 50)
                recolourOriginal[opcode - 40] = stream.g2();
            else
            if(opcode >= 50 && opcode < 60)
                recolourTarget[opcode - 50] = stream.g2();
            else
            if(opcode >= 60 && opcode < 70)
                headModelIDs[opcode - 60] = stream.g2();
            else
                System.out.println("Error unrecognised config code: " + opcode);
        } while(true);
    }

    public boolean isBodyDownloaded()
    {
        if(bodyModelIDs == null)
            return true;
        boolean is_downloaded = true;
        for(int ptr = 0; ptr < bodyModelIDs.length; ptr++)
            if(!Model.isDownloaded(bodyModelIDs[ptr]))
                is_downloaded = false;

        return is_downloaded;
    }

    public Model getBodyModel()
    {
        if(bodyModelIDs == null)
            return null;
        Model sub_models[] = new Model[bodyModelIDs.length];
        for(int model_ptr = 0; model_ptr < bodyModelIDs.length; model_ptr++)
            sub_models[model_ptr] = Model.getModel(bodyModelIDs[model_ptr]);

        Model model;
        if(sub_models.length == 1)
            model = sub_models[0];
        else
            model = new Model(sub_models.length, sub_models);
        for(int colour_ptr = 0; colour_ptr < 6; colour_ptr++)
        {
            if(recolourOriginal[colour_ptr] == 0)
                break;
            model.recolour(recolourOriginal[colour_ptr], recolourTarget[colour_ptr]);
        }

        return model;
    }

    public boolean isHeadDownloaded()
    {
        boolean isDownloaded = true;
        for(int ptr = 0; ptr < 5; ptr++)
            if(headModelIDs[ptr] != -1 && !Model.isDownloaded(headModelIDs[ptr]))
                isDownloaded = false;

        return isDownloaded;
    }

    public Model getHeadModel()
    {
        Model sub_models[] = new Model[5];
        int model_ptr = 0;
        for(int id_ptr = 0; id_ptr < 5; id_ptr++)
            if(headModelIDs[id_ptr] != -1)
                sub_models[model_ptr++] = Model.getModel(headModelIDs[id_ptr]);

        Model model = new Model(model_ptr, sub_models);
        for(int colour_ptr = 0; colour_ptr < 6; colour_ptr++)
        {
            if(recolourOriginal[colour_ptr] == 0)
                break;
            model.recolour(recolourOriginal[colour_ptr], recolourTarget[colour_ptr]);
        }

        return model;
    }

    private IdentityKit()
    {
        bodyPartID = -1;
        recolourOriginal = new int[6];
        recolourTarget = new int[6];
        notSelectable = false;
    }

    public static int length;
    public static IdentityKit cache[];
    public int bodyPartID;
    private int[] bodyModelIDs;
    private final int[] recolourOriginal;
    private final int[] recolourTarget;
    private final int[] headModelIDs = {
        -1, -1, -1, -1, -1
    };
    public boolean notSelectable;
}