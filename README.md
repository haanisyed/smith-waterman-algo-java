# smith-waterman-algo-java
**Smith Waterman Algorithm Java Implementation with comparison of Mycoplasmoides genitalium G37 Strain and Basic Generic Sequence.**

Important Bioinformatics Dynamic Programming Algorithm used in local sequence alignment implemented in Java. Used to find the optimal local alignment between two genomic sequences. Sequence1 in the code represents the genomic sequence of   Mycoplasmoides genitalium G37 Strain (approximately 580,070 base pairs) as found on NCBI, whilst the Sequence2 is a basic generic "AGT".

FNA File Downloaded from -> Genomic Sequence:https://www.ncbi.nlm.nih.gov/datasets/genome/GCF_000027325.1/

The key idea behind the Smith-Waterman algorithm is to identify the most significant local similarities between two sequences rather than finding the global alignment of the entire sequences. This makes it particularly useful for identifying similar regions in biological sequences that may have undergone insertions, deletions, or mutations.

The algorithm works by creating a matrix that represents all possible alignments between subsequences of the input sequences. It then calculates scores for each possible alignment based on a scoring system that assigns values to matches, mismatches, and gaps. The dynamic programming approach is employed to fill in the matrix, and the optimal local alignment is determined by identifying the highest-scoring sub-matrix within the larger matrix.

The Smith-Waterman algorithm is sensitive to local similarities, making it valuable for applications such as database searches for similar biological sequences and the identification of functional domains within proteins. While it can be computationally intensive for large sequences, its ability to find local similarities makes it a powerful tool in bioinformatics and computational biology.

 Original Mathematical Algorithm developed by Temple F. Smith and Michael S. Waterman in 1981.
