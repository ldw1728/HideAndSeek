package Object;

import java.awt.Rectangle;
import java.util.ArrayList;

public class CreateMapObject {
	private ArrayList<MapObject> Trees;
	private ArrayList<MapObject> pools;
	private ArrayList<MapObject> roots;
	private ArrayList<MapObject> rock;
	private ArrayList<MapObject> cornField;
	private ArrayList<MapObject> moai;
	private ArrayList<MapObject> etc;
	private House1 h1;
	private House2 h2;
	private EscapeDoor ed = null;

	private ArrayList<ArrayList<MapObject>> objects;

	public CreateMapObject() {
		objects = new ArrayList<ArrayList<MapObject>>();
		createTrees();
		createPools();
		createTreeRoots();
		createRock();
		createCornField();
		createMoai();
		createEtc();
		createHouse();

	}

	public void createED() {
		ed = new EscapeDoor(687, 723);
	}

	public EscapeDoor getED() {
		return this.ed;
	}

	public ArrayList<ArrayList<MapObject>> getObjects() {
		return this.objects;
	}

	public void createTrees() {
		Trees = new ArrayList<MapObject>();

		Trees.add(new Tree(1189, 221));
		Trees.add(new Tree(154, 224));
		Trees.add(new Tree(271, 397));
		Trees.add(new Tree(415, 788));
		Trees.add(new Tree(623, 268));
		Trees.add(new Tree(662, 265));
		Trees.add(new Tree(676, 109));
		Trees.add(new Tree(792, 343));
		Trees.add(new Tree(779, 687));
		Trees.add(new Tree(1150, 543));
		Trees.add(new Tree(1447, 638));

		objects.add(Trees);
	}

	public void createPools() {
		pools = new ArrayList<MapObject>();
		pools.add(new Pool(439, 284));
		pools.add(new Pool(168, 536));
		pools.add(new Pool(1025, 759));

		objects.add(pools);
	}

	public void createTreeRoots() {
		roots = new ArrayList<MapObject>();

		roots.add(new TreeRoot(387, 100));
		roots.add(new TreeRoot(516, 698));
		roots.add(new TreeRoot(1382, 467));

		objects.add(roots);
	}

	public void createRock() {
		rock = new ArrayList<MapObject>();

		rock.add(new Rock(925, 409));
		rock.add(new Rock(977, 417, 35, 40));

		objects.add(rock);
	}

	public void createCornField() {
		cornField = new ArrayList<MapObject>();

		cornField.add(new CornField(1278, 251, 262, 89));

		objects.add(cornField);
	}

	public void createMoai() {
		moai = new ArrayList<MapObject>();

		moai.add(new Moai(1299, 13));
		moai.add(new Moai(1382, 13));
		moai.add(new Moai(1476, 13));

		objects.add(moai);

	}

	public void createEtc() {
		etc = new ArrayList<MapObject>();

		etc.add(new SmallHouse(1254, 680));

		objects.add(etc);
	}

	public void createHouse() {

		h1 = new House1(585, 450);
		h2 = new House2(817, 17);
	}

	public House1 getH1() {
		return this.h1;
	}

	public House2 getH2() {
		return this.h2;
	}

	public ArrayList<MapObject> getTrees() {
		return this.Trees;
	}

	public ArrayList<MapObject> getMoai() {
		return this.moai;
	}

	public ArrayList<MapObject> getCornField() {
		return this.cornField;
	}

	public ArrayList<MapObject> getRock() {
		return this.rock;
	}

	public ArrayList<MapObject> getPools() {
		return this.pools;
	}

	public ArrayList<MapObject> getEtc() {
		return this.etc;
	}

}
