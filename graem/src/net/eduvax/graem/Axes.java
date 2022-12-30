/*
 * @file Axes.java
 *
 * Copyright 2022 Sebastien Devaux. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id$
 * $Date$
 */
package net.eduvax.graem;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.debug.Arrow;
import com.jme3.scene.Node;

/**
 *
 */
public class Axes extends SceneComposition {
    private AssetManager _assetManager;
    private float _width=8;

    public void setWidth(float w) {
        _width=w;
    }

    private void addAxe(String name, Node parent, Vector3f dir, ColorRGBA color) {
        Arrow arrow=new Arrow(dir);
        arrow.setLineWidth(_width);
        Geometry g = new Geometry(name, arrow);
        Material mat = new Material(_assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.getAdditionalRenderState().setWireframe(true);
        mat.setColor("Color", color);
        g.setMaterial(mat);
        parent.attachChild(g);    
    }

    @Override public void build(View view) {
        Node parent=view.getRootNode();
        _assetManager=view.getAssetManager();
        Node axes=new Node(getName());
        parent.attachChild(axes);
        addAxe("X",axes,Vector3f.UNIT_X,ColorRGBA.Red);
        addAxe("Y",axes,Vector3f.UNIT_Y,ColorRGBA.Green);
        addAxe("Z",axes,Vector3f.UNIT_Z,ColorRGBA.Blue);
    }

}
