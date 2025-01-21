package com.ms.data.structures.trees.binarytree.playground;


import java.util.ArrayList;
import java.util.List;

import com.ms.data.playground.revision.binarytree.NodeToLeafNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ms.data.structures.trees.binarytree.BuildTree;
import com.ms.data.structures.trees.binarytree.TreeNode;

class NodeToLeafNodesTest {

	TreeNode root;

    @BeforeEach
    void setUp() {
        int[] input = {1, 2, 2, 3, 4, 4, 3, -1, -1, -1, -1, -1, -1, -1, -1};
        root = BuildTree.buildTreeLevel(input);
        System.out.println("~~~~~~~~~~~~~~~");
    }
    

	@Test
	void test() {
		BuildTree.printLevelLn(root);
		List<List<Integer>> ansList =  NodeToLeafNodes.getNodeToLeaf(root, new ArrayList<>(), new ArrayList<>());
		System.out.println(ansList);
	}

}
