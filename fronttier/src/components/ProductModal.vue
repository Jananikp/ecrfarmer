<template>
  <!-- Backdrop with click listener -->
  <div
    class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50"
    @click.self="$emit('close')" 
  >
    <!-- Modal card -->
    <div
      class="bg-white p-6 rounded-lg w-full max-w-md relative shadow-lg"
    >
      <button
        @click="$emit('close')"
        class="absolute top-2 right-2 text-gray-600 hover:text-black"
      >
        ✕
      </button>

      <img :src="product.imageUrl" class="w-full h-48 object-cover rounded" />
      <h2 class="text-xl font-bold mt-4">{{ product.name }}</h2>
      <p class="text-gray-600">{{ product.description }}</p>
      <p class="mt-2"><strong>Available:</strong> {{ product.quantity }} kg</p>
      <p><strong>Price:</strong> ₹{{ product.price.toFixed(2) }} / kg</p>
    </div>
  </div>
</template>

<script setup>
defineProps({
  product: Object,
})
</script>
