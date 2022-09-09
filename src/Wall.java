import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    BlockFabric blockFabric = new BlockFabric();
    private List<BlockFabric> blocks = blockFabric.getBlocks();


    @Override
    public BlockFabric findBlockByColor(String color) {
        for(int i=0; i<blocks.size(); i++ ){
            if(color.equals(blocks.get(i).getColor())){
                return blocks.get(i);
            }
        }
        return null;
    }

    @Override
    public List findBlocksByMaterial(String material) {
        List<BlockFabric> blocksByMaterial = new ArrayList<>();
        for(BlockFabric b : blocks){
            if(b.getMaterial().equals(material)){
                blocksByMaterial.add(b);
            }

        }
        return blocksByMaterial;
    }

    @Override
    public int count() {
        return blocks.size();
    }
}

interface Structure {
    // zwraca dowolny element o podanym kolorze
    BlockFabric findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

interface Block {
    String getColor();
    String getMaterial();
}

interface CompositeBlock extends Block {
    List getBlocks();
}

class BlockFabric implements CompositeBlock{

    private String color;
    String material;
    private static List<BlockFabric> blocks;

    public BlockFabric() {
    }

    public BlockFabric(String color, String material) {
        this.color = color;
        this.material = material;
        BlockFabric.blocks.add(this);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List<BlockFabric> getBlocks() {
        return blocks;
    }


}
